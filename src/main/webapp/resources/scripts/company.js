YUI().use( "datasource-io", "datasource-jsonschema", "datatable-base", "datatable-datasource",
           function (Y) {
    var cols = [   
            { key: "companyNo",  label: "Company No"  }, 
            { key: "companyName", label: 'Company Name'  },
            {
                key: 'address',
                locator: "address.address1",
                label: "Address 1"
            },
            {
                key: 'address',
                locator: "address.address2",
                label: "Address 2"
            },
            {
                key: 'address',
                locator: "address.address3",
                label: "Address 3"
            },
            {
                key: 'address',
                locator: "address.city",
                label: "City"
            },
            {
                key: 'address',
                locator: "address.town",
                label: "Town"
                	
            },
            {
                key: 'address',
                locator: "address.country",
                label: "Country"
                	
            },
            { key: "incorporationDate",  label: "Incorporation Date"  } 
        ];
    var url = "listCompany?";
    var ds = new Y.DataSource.IO( {
        source: url
     });
     ds.plug(Y.Plugin.DataSourceJSONSchema, {
            schema: {
            	 resultFields: [
	                "companyNo",
	                "companyName",
	                {
	                    key: 'address',
	                    locator: "address.address1"
	                },
	                {
	                    key: 'address.address2',
	                    locator: "address.address2"
	                },
	                {
	                    key: 'address',
	                    locator: "address.address3"
	                },
	                {
	                    key: 'address',
	                    locator: "address.city"
	                },
	                {
	                    key: 'address',
	                    locator: "address.town"
	                },
	                {
	                    key: 'address',
	                    locator: "address.country"
	                },
	                "incorporationDate"
	            ]
            }
        });
    var dt = new Y.DataTable.Base({
        columnset:cols } )
        .plug(Y.Plugin.DataTableDataSource, {datasource:ds});
    dt.render("#companies");
    dt.datasource.load();
});
