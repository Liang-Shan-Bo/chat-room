<!DOCTYPE html>
<html>
<head>
	<%@ include file="/WEB-INF/views/includes.jsp"%>
	<%@ include file="/WEB-INF/views/jq.jsp"%>
    <title>jqGrid Loading Data - Sort By Multiple Columns</title>
</head>
<body>

    <table id="jqGrid"></table>
    <div id="jqGridPager"></div>

    <script type="text/javascript"> 
    
        $(document).ready(function () {
            $("#jqGrid").jqGrid({
                url: '<c:url value="/g/sortm.json" />',
                datatype: "json",
                jsonReader : { repeatitems: false },
                colModel: [
                    { label: 'Category Name', name: 'CategoryName', width: 75 },
                    { label: 'Product Name', name: 'ProductName', width: 90 },
                    { label: 'Country', name: 'Country', width: 100 },
                    { label: 'Price', name: 'Price', width: 80, sorttype:'number' },
                    { label: 'Quantity', name: 'Quantity', width: 80, sorttype:'integer' }                   
                ],
                loadonce: true,
                multiSort: true,
                width: 780,
                height: 200,
                rowNum: 15,
				viewrecords: true,
                pager: "#jqGridPager",
                caption: "Amounts of each product category"
            });
        });

    </script>

    
</body>
</html>