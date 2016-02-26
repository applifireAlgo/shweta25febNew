Ext.define('Testtwo.view.reportui.ReportView', {
	extend : 'Ext.panel.Panel',
	requires : [ 'Testtwo.view.reportui.querycriteria.QueryCriteriaView',
			'Testtwo.view.reportui.datachart.DataChartViewTab',
			'Testtwo.view.reportui.datachart.DataChartViewPanel',
			'Testtwo.view.reportui.ReportViewController' ,
			'Testtwo.view.fw.MainDataPointPanel',
			'Testtwo.view.googlemaps.map.MapPanel'
			],
	xtype : 'reportview',
	controller : 'reportviewController',
	layout : 'border',
	isCustomReport:false,
	reportWidgets :["1","2","3","4"],
	//autoScroll : true,
	//margin : '3 0 5 0',
	height:500,
	width:"100%",
	listeners : {
		scope : 'controller',
		afterrender : 'renderReport'
	}
});
