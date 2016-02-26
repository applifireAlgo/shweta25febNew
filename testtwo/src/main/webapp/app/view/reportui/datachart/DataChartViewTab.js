Ext.define('Testtwo.view.reportui.datachart.DataChartViewTab', {
	extend : 'Ext.tab.Panel',
	requires : [ 'Testtwo.view.reportui.datachart.DataChartTController',
	             'Testtwo.view.reportui.datachart.datagrid.DataGridView',
	             'Testtwo.view.reportui.datachart.chart.ChartTabView',
	             'Testtwo.view.reportui.datachart.ChartPointView' ],
	controller : 'datacharttController',
	xtype : 'datachart-tabpanel',
	tabPosition : 'bottom',
	bodyStyle : 'background:#D8D8D8',
	listeners : {
		scope : "controller",
		tabchange : 'tabchange',
		afterrender:'afterTabPanelRender'
	}
});