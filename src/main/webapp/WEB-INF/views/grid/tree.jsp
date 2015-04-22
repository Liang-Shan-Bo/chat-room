<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/includes.jsp"%>
	<%@ include file="/WEB-INF/views/jq.jsp"%>
        <title>jqTreeGrid - Load On Demand - Load all Rows at once collapsed</title>
</head>
<body>
    Group By: <select id="chngroup">
        <option value="CustomerID" selected="selected">CustomerID</option>
        <option value="clear">Remove Grouping</option>    
        </select>
	<br/> <br/>
    <table id="jqGrid"></table>
    <div id="jqGridPager"></div>

    <script type="text/javascript"> 
    
        $(document).ready(function () {
            $("#jqGrid").jqGrid({
            	url: '<c:url value="/g/tree1.json" />',
                jsonReader : { repeatitems: false },
                mtype: "GET",
                datatype: "json",
                colModel: [
                    { label: 'OrderID', name: 'OrderID', key: true, width: 75 },
 					{ label: 'Customer ID', name: 'CustomerID', width: 150 },
                    { label: 'Order Date', name: 'OrderDate', width: 150 },
                    { label: 'Freight', name: 'Freight', width: 150 },
                    { label:'Ship Name', name: 'ShipName', width: 150 }
                ],
				loadonce:true, // just for demo purpose
                width: 780,
                height: 250,
                rowNum: 20,
				rowList:[20,25,50],
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
                    
                }
            });
			$("#jqGrid").jqGrid("navGrid","#jqGridPager",{add:false, edit:false, del:false});
			// on chang select value change grouping
			jQuery("#chngroup").change(function(){
				var vl = $(this).val();
				if(vl) {
					if(vl === "clear") {
						jQuery("#jqGrid").jqGrid('groupingRemove',true);
					} else {
						jQuery("#jqGrid").jqGrid('groupingGroupBy',vl);
					}
    }
}); 			
        });
    </script>

    
</body>
</html>
