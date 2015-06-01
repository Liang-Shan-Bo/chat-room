<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/includes.jsp"%>
	<%@ include file="/WEB-INF/views/jq.jsp"%>
        <title>test</title>
</head>
<body>
	<input id="expandAll" type="button" value="+" />
	<input id="collapseAll" type="button" value="-" />	
	<br/> <br/>
    <table id="jqGrid"></table>
    <div id="jqGridPager"></div>

    <script type="text/javascript"> 
    
        $(document).ready(function () {   	

        	$("#test1").bind("bind", function(){
        		hid = $t.p.id+"ghead_"+i;
        		
        	});
        	
        	
        	var opt = {
                	url: '<c:url value="/g/tree1.json" />',
                    jsonReader : { repeatitems: false },
                    mtype: "GET",
                    datatype: "json",
                    colModel: [
                        { label: 'OrderID', name: 'OrderID', key: true, width: 75, sortable:false},
     					{ label: 'Customer ID', name: 'CustomerID', width: 150 },
                        { label: 'Order Date', name: 'OrderDate', width: 150 },
                        { label: 'Freight', name: 'Freight', width: 150 },
                        { label:'Ship Name', name: 'ShipName', width: 150, sortable:false }
                    ],
    				loadonce:true, // just for demo purpose
                    width: 780,
                    height: 'auto',
                    rowNum: 10,
    				rowList:[10,25,50],
    				sortname: 'OrderID',
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
                    groupingSort:true,
                    lastgroupsort : 0
                };
        	
            $("#jqGrid").jqGrid(opt);
            $("#jqGrid").jqGrid("groupingToggleAll", $("#expandAll"), $("#collapseAll"));
			
        });
    </script>

    
</body>
</html>
