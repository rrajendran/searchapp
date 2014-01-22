YUI().use("datatable", "datasource-get", "datasource-jsonschema", "datatable-datasource", function (Y) {

    var url = "listCompany",
        query = "?",
        dataSource,
        table;

    dataSource = new Y.DataSource.Get({ source: url });

    dataSource.plug(Y.Plugin.DataSourceJSONSchema, {
        schema: {
        	 resultListLocator: "company",
            resultFields: [
                "id",
                "name"
               
            ]
        }
    });

    table = new Y.DataTable({
        columns: [
				"Id",
				"Name"
        ],
        summary: "Agencies" 
    });
    
    table.plug(Y.Plugin.DataTableDataSource, { datasource: dataSource });

    table.render("#agencies");

    table.datasource.load({ request: query });
});