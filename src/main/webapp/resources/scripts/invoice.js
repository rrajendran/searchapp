YUI().use( "datasource-io", "datasource-jsonschema", "datatable-base", "datatable-datasource",
		function (Y) {

	function formatDates(o) {
		alert(o.value);
		return o.value &&
		Y.DataType.Date.format(o.value, { format: "%m/%d/%Y" });
	}

	function formatCurrency(o) {
		return Y.DataType.Number.format(o.value, {
			prefix:"£ ",
			thousandsSeparator: ",",
			decimalSeparator: ".",
			decimalPlaces: 2
		});
	}

	var cols = [   
	            { key: "id",  label: "Id"  }, 
	            { key: "agency", locator: "agency.name", label: 'Agency Name'  },
	            { key: "fromDate",  label: "From Date" },
	            { key: "toDate",  label: "To Date"  }, 
	            { key: "rate",  label: "Rate"  }, 
	            { key: "days",  label: "Days"  }, 
	            { key: "vat",  label: "VAT(%)"  },
	            { key: "total",  label: "Total" , formatter: formatCurrency }
	            ];
	var recordType = {
			id: {},
			agency: {},
			fromDate: {},
			toDate: {},
			rate: {},
			days: {},
			vat: {},
			total: {
				getter: function () {
					var total = this.get('days') * this.get('rate');
					var vatAmt = total * (this.get("vat") / 100);
					return total + vatAmt;
				},
				readOnly: true
			}
	};

	var url = "listInvoice?";
	var ds = new Y.DataSource.IO( {
		source: url
	});
	ds.plug(Y.Plugin.DataSourceJSONSchema, {
		schema: {
			resultFields: [
			               "id",
			               {
			            	   key: "agency",
			            	   locator: "agency.name"
			               },
			               "fromDate",
			               "toDate",
			               "rate",
			               "days",
			               "vat"
			               ]

		}
	});
	var dt = new Y.DataTable.Base({
		columnset:cols, recordType : recordType } )
	.plug(Y.Plugin.DataTableDataSource, {datasource:ds});
	dt.render("#invoices");
	dt.datasource.load();
});
