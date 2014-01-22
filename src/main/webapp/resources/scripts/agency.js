YUI().use("datatable", "datasource-get", "datasource-jsonschema", "datatable-datasource", function (Y) {

    var url = "listAgencies",
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
});