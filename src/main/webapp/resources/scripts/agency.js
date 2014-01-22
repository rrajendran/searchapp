YUI().use( "datasource-io", "datasource-jsonschema", "datatable-base", "datatable-datasource",
           function (Y) {
    var cols = [   
            { key: "id",  label: "id"  }, 
            { key: "name", label: 'Name'  },
            { key: "emailId",  label: "EmailId"  },
            { key: "address1",  label: "address1"  }, 
            { key: "address2",  label: "address2"  }, 
            { key: "city",  label: "city"  }, 
            { key: "town",  label: "town"  }, 
            { key: "country",  label: "country"  }, 
            { key: "mobile",  label: "mobile"  }, 
            { key: "telephone",  label: "telephone"  }
        ];
    var url = "listAgency?";
    var ds = new Y.DataSource.IO( {
        source: url
     });
     ds.plug(Y.Plugin.DataSourceJSONSchema, {
            schema: {
            	 resultFields: [
	                "id",
	                "name",
	                "address1",
	                "address2",
	                "city",
	                "town",
	                "country",
	                "postCode",
	                "mobile",
	                "telephone",
	                "emailId"
	            ]
            }
        });
    var dt = new Y.DataTable.Base({
        columnset:cols } )
        .plug(Y.Plugin.DataTableDataSource, {datasource:ds});
    dt.render("#agencies");
    dt.datasource.load();
});


/*
YUI().use("datatable", "datasource-get", "datasource-jsonschema", "datatable-datasource", function (Y) {

    var url = "listAgency",
        query = "?",
        dataSource,
        table;

    dataSource = new Y.DataSource.Get({ source: url });

    dataSource.plug(Y.Plugin.DataSourceJSONSchema, {
        schema: {
        	 resultListLocator: "agencies",
            resultFields: [
                "id",
                "name",
                "address1",
                "address2",
                "city",
                "town",
                "country",
                "postCode",
                "mobile",
                "telephone",
                "emailId"
            ]
        }
    });

    table = new Y.DataTable({
        columns: [
				"Id",
				"Name",
				"Address 1",
				"Address 2",
				"City",
				"Town",
				"Country",
				"Post Code",
				"Mobile",
				"Telephone",
				"Email Id"
        ],
        summary: "Agencies" 
    });
    
    table.plug(Y.Plugin.DataTableDataSource, { datasource: dataSource });

    table.render("#agencies");

    table.datasource.load({ request: query });
});*/