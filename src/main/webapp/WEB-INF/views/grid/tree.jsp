<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/includes.jsp"%>
	<%@ include file="/WEB-INF/views/jq.jsp"%>
        <title>test</title>
</head>
<body>
	<br/> <br/>
    <table id="jqGrid"></table>
    <div id="jqGridPager"></div>

    <script type="text/javascript"> 
    
        $(document).ready(function () {   	

        	var opt = {
                	url: '<c:url value="/g/tree1.json" />',
                    jsonReader : { repeatitems: false },
                    mtype: "GET",
                    datatype: "json",
                    colModel: [
                        { label: 'OrderID', name: 'OrderID', key: true, width: 75},
     					{ label: 'Customer ID', name: 'CustomerID', width: 150 },
                        { label: 'Order Date', name: 'OrderDate', width: 150 },
                        { label: 'Freight', name: 'Freight', width: 150 },
                        { label:'Ship Name', name: 'ShipName', width: 150 }
                    ],
    				loadonce:true, // just for demo purpose
                    width: 780,
                    height: 250,
                    rowNum: 10,
    				rowList:[10,25,50],
    				sortname: 'OrderDate',
                    pager: "#jqGridPager",
    				viewrecords: true,
                    grouping: true,
                    groupingView: {
                        groupField: ["CustomerID"],
                        groupColumnShow: [true],
                        groupText: ["<b>{0}</b>"],
                        groupOrder: ["asc"],
                        groupSummary: [false],
                        groupCollapse: false
                        
                    },
                    groupingSort:true
                };
        	
            $("#jqGrid").jqGrid(opt);
		
        });
    </script>

    
</body>
</html>
