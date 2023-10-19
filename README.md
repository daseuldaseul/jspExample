

<!DOCTYPE html>

<html lang="ko">
<head>
    <meta name="viewport" content="width=device-width" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="cache-control" content="no-cache" />
    <meta http-equiv="Pragma" content="no-cache" />
    <meta http-equiv="expires" content="-1" />
     
    
        <title>[DEV] NETS*OPS</title>
    
    
    
<link rel="shortcut icon" href="/_content/Nets.O365M.Web.Platform/images/favicon.ico" />
<link rel="stylesheet" href="/_content/Nets.O365M.Web.Platform/lib/color-admin/css/vendor.min.css" />

    <link rel="stylesheet" href="/_content/Nets.O365M.Web.Platform/lib/jqgrid/css/ui.jqgrid.css" />
    <link rel="stylesheet" href="/_content/Nets.O365M.Web.Platform/lib/bootstrap-sweetalert/sweetalert.css" />
    <link rel="stylesheet" href="/_content/Nets.O365M.Web.Platform/lib/bootstrap-datepicker/css/bootstrap-datepicker.css" />
    <link rel="stylesheet" href="/_content/Nets.O365M.Web.Platform/lib/bootstrap-daterangepicker/daterangepicker.css" />
    <link rel="stylesheet" href="/_content/Nets.O365M.Web.Platform/lib/jstree/themes/default/style.min.css" />
    <link rel="stylesheet" href="/_content/Nets.O365M.Web.Platform/lib/color-admin/css/default/app.min.css" />
    <link rel="stylesheet" href="/_content/Nets.O365M.Web.Platform/lib/toastr.js/toastr.css" /> 
    <link rel="stylesheet" href="/_content/Nets.O365M.Web.Platform/css/base.css?v=hdXdhHjtjillMsusyBal16LDhQ1nrAdOvV5zugIySjk" />
    <link rel="stylesheet" href="/_content/Nets.O365M.Web.Platform/lib/select2/css/select2.min.css" />



     
        <link rel="stylesheet" href="/css/site.css?v=NIb-I_zkDuIka8V4iFeaeoTLOUfweXz5LtWh-d1xRgk" />
    
</head>
<body>
    <header>
        <!-- BEGIN #loader -->
        <div id="loader" class="app-loader">
            <span class="spinner"></span>
        </div>
        <!-- END #loader -->
    </header>
    <!-- BEGIN #vendor import -->
    <script src="/_content/Nets.O365M.Web.Platform/lib/color-admin/js/vendor.min.js"></script>
    <!-- END #vendor import -->
    <div id="app" class="app app-header-fixed app-sidebar-fixed">
        <!-- BEGIN #header -->
        <div id="header" class="app-header">
            <!-- BEGIN navbar-header -->
            <div class="navbar-header">
                <a href="/" class="navbar-brand">
                     
        <b>NETS*OPS</b>&nbsp;
    
                </a>
                <button type="button" class="navbar-mobile-toggler" data-bs-toggle="collapse" data-bs-target="#top-navbar">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            </div>
            <!-- END navbar-header -->
            <!-- BEGIN navbar-collapse -->
            <div class="collapse d-md-block me-auto" id="top-navbar">
                <!-- TODO display:block on xs screen.-->
                <div class="navbar-nav">
                     
        

    <div class="navbar-item active">
        <a href="javascript:;" class="navbar-link d-flex align-items-center" onclick="_vmTopMenu.action.onClickMenu(this)" data-id="12" data-toggle="app-sidebar-mobile">
            <span class="d-lg-inline">제품 및 배포</span>
        </a>
    </div>
    <div class="navbar-item ">
        <a href="javascript:;" class="navbar-link d-flex align-items-center" onclick="_vmTopMenu.action.onClickMenu(this)" data-id="13" data-toggle="app-sidebar-mobile">
            <span class="d-lg-inline">문서</span>
        </a>
    </div>

<script>
    const _vmTopMenu = {
        cache: {
            menuCache: {}
        },
        action: {
            onClickMenu: function (elem, activeID) {
                if ($('#sidebar-outer').length) {
                    //fullsize 페이지에서 대시보드 등 side 메뉴가 없는 페이지인 경우 상단메뉴 클릭시 사이드바 강제 표시
                    $('#app').removeClass('app-without-sidebar');
                    $('#sidebar-outer').show();
                }

                let menuID = $(elem).data('id');
                let cacheKey = '544_' + menuID;
                $('#header').find('div.navbar-item.active').removeClass('active');
                $(elem).parent().addClass('active');

                //sidemenu 는 항상 조회하지 않고 캐시된 값을 사용
                if (_vmTopMenu.cache.menuCache[cacheKey]) {
                    $('#sidebar').find('.menu-header').nextAll().remove();
                    $('#sidebar').find('.menu').append(_vmTopMenu.cache.menuCache[cacheKey]);
                    //페이지 refresh 시 현재 url을 기준으로 메뉴를 선택
                    _vmTopMenu.action.activateSelectedMenu('102');
                }
                else {
                    let loader = BaseScriptUtil.getLoadIndicator();
                    $.ajax({
                        url: '/UICommon/Navigation/SideMenu?parentid=' + menuID,
                        type: 'GET',
                        beforeSend: function () {
                            $('#sidebar').find('.menu-header').nextAll().remove();
                            $('#sidebar').find('.menu').append(loader);
                        },
                        success: function (result) {
                            $('#sidebar').find('.menu-header').nextAll().remove();
                            $('#sidebar').find('.menu').append(result);
                            _vmTopMenu.cache.menuCache[cacheKey] = result;

                            //페이지 refresh 시 현재 url을 기준으로 메뉴를 선택
                            _vmTopMenu.action.activateSelectedMenu('102');
                        }
                    });
                }
            },
            activateSelectedMenu: function (menuID) {
                if (menuID) {
                    //선택된 메뉴와 그 부모 메뉴를 모두 activate 한다.
                    var selectedMenu = $('#sidebar').find('div.menu-item[name="' + menuID + '"]');
                    $(selectedMenu).addClass('active');
                    $(selectedMenu).parents('div.menu-item').addClass('active');
                }
            }
        }
    };

    $(function () {
        //페이지 refresh 시 상단 메뉴가 선택되어 있는 경우 sidemenu 도 선택
        var selected = $('#header').find('div.navbar-item.active a');
        if (selected.length > 0) {
            _vmTopMenu.action.onClickMenu(selected, '102');
        }
    });
</script>
    
                </div>
            </div>
            <!-- END navbar-collapse -->
            <div class="navbar-nav">
                 <div class="navbar-item navbar-user dropdown">
                    <a href="#" class="navbar-link dropdown-toggle d-flex align-items-center text-decoration-none" data-bs-toggle="dropdown">
                        <i class="fas fa-globe-americas"></i>
                    </a>
                    <div class="dropdown-menu dropdown-menu-end me-1">
                            <a class="dropdown-item text-truncate " href="/UICommon/Navigation/SetLanguages?culture=en-US">
                                English (United States)
                            </a>
                            <a class="dropdown-item text-truncate active" href="/UICommon/Navigation/SetLanguages?culture=ko-KR">
                                한국어(대한민국)
                            </a>
                    </div>
                </div>
                <div class="navbar-item navbar-user dropdown">
                    <a href="#" class="navbar-link dropdown-toggle d-flex align-items-center" data-bs-toggle="dropdown">
                        <i class="fas fa-user"></i>&nbsp;
                        <span>

                            <!--스크린 사이즈가 작아지는 경우 UPN이 사라지는게 권장 디자인이나 해당 영역에 표시할 다른 컨텐츠가 없으므로 작아져도 UPN을 표시하도록 수정함-->
                                <span class="">pds2754@nets.co.kr</span>
                            <b class="caret"></b>
                        </span>
                    </a>
                    <div class="dropdown-menu dropdown-menu-end me-1">
                                <a class="dropdown-item" href="/MicrosoftIdentity/Account/SignOut">Sign Out</a>
                    </div>
                </div>
            </div>
            <!-- END header-nav -->
        </div>
        <!-- END #header -->
        <!-- BEGIN #sidebar -->
            <div id="sidebar-outer">
                <div id="sidebar" class="app-sidebar">
                    <!-- BEGIN scrollbar -->
                    <div class="app-sidebar-content" data-scrollbar="true" data-height="100%">
                        <div class="menu">
                            <div class="menu-profile">
                                <a href="javascript:;" class="menu-profile-link" data-toggle="app-sidebar-profile" data-target="#appSidebarProfileMenu">
                                    <div class="menu-profile-cover with-shadow"></div>
                                    <div class="menu-profile-image">
                                        <i class="fas fa-2x fa-user-circle"></i>
                                    </div>
                                    <div class="menu-profile-info">
                                        <div class="d-flex align-items-center">
                                                <div class="flex-grow-1 text-truncate" title="박다슬">
                                                    박다슬
                                                </div>

                                        </div>
                                        <small class="text-truncate" title="박다슬(pds2754)">박다슬(pds2754)</small>
                                    </div>
                                </a>
                            </div>
                            <div class="menu-header">Navigation</div>
                            <!-- SideMenu Items-->
                        </div>
                    </div>
                </div>
                <div class="app-sidebar-bg"></div>
                <div class="app-sidebar-mobile-backdrop"><a href="#" data-dismiss="app-sidebar-mobile" class="stretched-link"></a></div>
            </div>
        <!-- END #sidebar -->
        <!-- BEGIN #content -->
        <div id="content" class="app-content">
            <div id="content-inner">
                




    <script src="/_content/Nets.O365M.Web.Platform/lib/codemirror/codemirror.js"></script>
    <script src="/_content/Nets.O365M.Web.Platform/lib/codemirror/mode/javascript/javascript.js"></script>



    <link href="/_content/Nets.O365M.Web.Platform/lib/codemirror/codemirror.css" rel="stylesheet">


<div class="portal-body">
    



    <ol class="breadcrumb float-xl-end">
        <li class="breadcrumb-item ">
                <a href="#">수신자 설정</a>
        </li>
    </ol>
<h1 class="page-header">

            수신자 설정
        </h1>


<div class="panel panel-inverse" >

    <div class="panel-heading ">
        <h4 class="panel-title text-truncate" title="수신자 설정">
            <text>수신자 설정</text>&nbsp;<small></small>
        </h4>
        <div class="panel-heading-btn">

            <a href="javascript:;" class="btn btn-xs btn-icon btn-default" data-toggle="panel-expand"><i class="fa fa-expand"></i></a>

            <a href="javascript:;" class="btn btn-xs btn-icon btn-warning" data-toggle="panel-collapse"><i class="fa fa-minus"></i></a>

        </div>
    </div>

    <div class="panel-body "  >

    <div style="display: flex; justify-content: space-between;">
        <div class="d-flex flex-wrap nets-btnarea">
            <button type="button" class="btn btn-primary" onclick="vm770E4C48.action.OnClickRegister()">등록</button>
            <div id="delBtn" style="display: none;">
                <button type="button" class="btn btn-primary" onclick="vm770E4C48.action.OnClickRemove()">삭제</button>
            </div>
            <select class="form-select w-200px" id="sel_pcode_770E4C48" required><option value="AAD">Entra ID(Azure AD)</option>
<option value="AADM">NETS*AzureAD Manager</option>
<option value="AADM.DEV">AADM(SaaS 관리) 개발</option>
<option value="M365">Microsoft 365</option>
<option value="O365M">NETS*O365 Manager</option>
<option value="OPS">OPS</option>
<option value="SaaS.Integration">SaaS 연동</option>
<option value="TEAMPROCESS">팀 업무</option>
<option value="TESTPROD">TESTPROD(개발)</option>
<option value="TESTPROD2">TESTPROD2(기술)</option>
</select>
        </div>
    </div>
     
<div id="tblModuleList_770E4C48" class="default-grid custom-jqgrid">
    <table id="tblModuleList_770E4C48_body"></table>
        <div id="Mailinglistpager_770E4C48"></div>
</div>
<script>
    $(function () {
        $('#tblModuleList_770E4C48_body').data('jqParams', {
  "url": "/mailingmgmt/list/data?pcode=AAD",
  "datatype": "json",
  "mtype": "POST",
  "colModel": [
    {
      "name": "prod_code",
      "fixed": false,
      "hidden": false,
      "index": "pcode",
      "key": false,
      "label": "\uC81C\uD488 \uCF54\uB4DC",
      "sortable": true,
      "editable": false,
      "width": 0
    },
    {
      "name": "domain_code",
      "fixed": false,
      "hidden": false,
      "index": "tdomaincode",
      "key": false,
      "label": "\uB3C4\uBA54\uC778 \uCF54\uB4DC",
      "sortable": true,
      "editable": false,
      "width": 0
    },
    {
      "name": "target_type",
      "fixed": false,
      "hidden": false,
      "index": "ttype",
      "key": false,
      "label": "\uC218\uC2E0\uC790 \uC720\uD615",
      "sortable": true,
      "editable": false,
      "width": 0,
      "formatter": "showMailingType"
    },
    {
      "name": "target_code",
      "fixed": false,
      "hidden": false,
      "index": "tcode",
      "key": false,
      "label": "\uC218\uC2E0\uC790 \uCF54\uB4DC",
      "sortable": true,
      "editable": false,
      "width": 0
    },
    {
      "name": "target_name",
      "fixed": false,
      "hidden": false,
      "index": "tname",
      "key": false,
      "label": "\uC218\uC2E0\uC790 \uC774\uB984",
      "sortable": true,
      "editable": false,
      "width": 0
    },
    {
      "name": "target_email",
      "fixed": false,
      "hidden": false,
      "index": "temail",
      "key": false,
      "label": "\uC218\uC2E0\uC790 \uC774\uBA54\uC77C",
      "sortable": true,
      "editable": false,
      "width": 0
    },
    {
      "name": "prod_check",
      "fixed": false,
      "hidden": true,
      "index": "pcheck",
      "key": false,
      "label": "",
      "sortable": false,
      "editable": false,
      "width": 0
    },
    {
      "name": "note_check",
      "fixed": false,
      "hidden": true,
      "index": "ncheck",
      "key": false,
      "label": "",
      "sortable": false,
      "editable": false,
      "width": 0
    },
    {
      "name": "errcode_check",
      "fixed": false,
      "hidden": true,
      "index": "echeck",
      "key": false,
      "label": "",
      "sortable": false,
      "editable": false,
      "width": 0
    }
  ],
  "page": 1,
  "pager": "Mailinglistpager_770E4C48",
  "height": "100%",
  "sortable": true,
  "sortname": "fcode",
  "sortorder": "asc",
  "authwidth": true,
  "viewrecords": true,
  "shrinkToFit": true,
  "multiselect": true,
  "rowselect": false,
  "removecolumn": false,
  "treeGrid": false,
  "rowList": [
    15,
    20,
    50,
    100
  ],
  "rowNum": 15,
  "subGrid": false,
  "bindkeys": false,
  "autoencode": false,
  "disableLastButton": false,
  "scroll": false
});
        let subGridLoadIndicator = '$("#" + subgrid_id).html("<div class=\\"text-center p-t-5 p-b-5\\"><i class=\\"fas fa-spinner fa-spin fa-3x\\"/></div>");';
        $('#tblModuleList_770E4C48_body').data('jqParams').subGridRowExpanded = new Function("subgrid_id", "row_id", subGridLoadIndicator + $('#tblModuleList_770E4C48_body').data('jqParams').subGridRowExpanded)
        $('#tblModuleList_770E4C48_body').data('jqParams').subGridOptions = {
            plusicon: "ui-icon-blank fas fa-plus",
            minusicon: "ui-icon-blank fas fa-minus",
            openicon: "ui-icon-blank",
            expandOnLoad: false,
            selectOnExpand: false,
            reloadOnExpand: false
        };
        
        $('#tblModuleList_770E4C48_body').data('jqParams').postData = {
            tableid: 'tblModuleList_770E4C48'
        };

        $('#tblModuleList_770E4C48_body').data('jqParams').jsonReader = {
            repeatitems: false,
            id: 'id'
        };

         $.map($('#tblModuleList_770E4C48_body').data('jqParams').colModel, function (row) {
            if (row.editable != undefined && row.editable == true && row.edittype == 'select') {
                if (row.editoptions == undefined) {
                    row.editoptions = {};
                }

                row.editoptions.dataEvents = [
                    {
                        type: 'change',
                        fn: function (e) {
                            var param = {};
                            param[row.name] = $(this).val();
                            param.url = 'clientArray';

                            $('#tblModuleList_770E4C48_body').jqGrid("saveRow", $(e.target).closest('tr.jqgrow').attr('id'), param);
                        }
                    }
                ]
            }
        });

        $('#tblModuleList_770E4C48').on('reload', function (e, params) {
            var page = (params != undefined && params.page != undefined) ? params.page : 1;
            $('#tblModuleList_770E4C48_body').jqGrid('setGridParam', { postData: params, page: page }).trigger('reloadGrid');
        });

        $('#tblModuleList_770E4C48_body').data('jqParams').loadComplete = function (data) {
            if (typeof data == 'undefined') return;
            var grid = this;

            if ($(grid).data('jqParams').disableLastButton) {
                $('#last_Mailinglistpager_770E4C48').addClass('ui-state-disabled');
            }

            $.map(data.rows, function (item) {
                $('#' + grid.id + ' tr#' + item.id + ' > td.tree-cbx > input[type=checkbox]').prop('checked', $('#' + grid.id + ' tr#' + data.rows[0].parent + ' > td.tree-cbx > input[type=checkbox]').prop('checked'));

                if ($(grid).data('jqParams') != undefined && $('#tblModuleList_770E4C48_body').data('jqParams').multiselect === true && item.cbx != undefined) {
                    if (item.cbx == false) {
                        $('#' + grid.id + ' tr#' + item.id.replace(/\./g, '\\.') + ' > td:first-child > input[type=checkbox]').prop('disabled', true);
                    }
                }
            });

            if ($(grid).data('jqParams') != undefined && $(grid).data('jqParams').rowselect === true) {
                $('#' + grid.id + ' tr.jqgrow').addClass('pointer');
            }

            if ($(grid).data('jqParams') != undefined && $(grid).data('jqParams').treeGrid && $(grid).data('jqParams').treeGrid === true && data.rows.length > 0) {
                if (data.rows[0].parent != null) {
                    $(grid).jqGrid('setCell', data.rows[0].parent, 'loaded', true);
                }
            }

            $(window).resize();

            if ($('#tblModuleList_770E4C48').width() < ($(window).width() / 2)) {
                setTimeout(function () {
                    $(window).resize();

                    if ($('#tblModuleList_770E4C48').width() < ($(window).width() / 2)) {
                        setTimeout(function () {
                            $(window).resize();
                        }, 500);
                    }
                }, 500);
            };

            $(grid).trigger('ModuleListLoadComplete', data);
        };

        //기본 오류 핸들러를 통해 오류가 처리되므로 아래의 jqgrid 호출 오류는 주석 처리.

        $('#tblModuleList_770E4C48_body').data('jqParams').gridComplete = function () {
            $('#tblModuleList_770E4C48').trigger('gridComplete');
        };

        $('#tblModuleList_770E4C48_body').data('jqParams').onSelectRow = function (rowid, status, e) {
            if ($('#tblModuleList_770E4C48_body').data('jqParams').multiselect === true && e.target.type == 'checkbox') {
                return false;
            }

            if (status) {
                $(this).jqGrid('editRow', rowid, true);
            } else {
                $(this).jqGrid('restoreRow', rowid);
            }

            $('#tblModuleList_770E4C48').trigger('onSelectRow', { rowid: rowid, status: status, rowData: $(this).jqGrid('getRowData', rowid) });
        };

        $('#tblModuleList_770E4C48_body').data('jqParams').beforeSelectRow = function (rowid, e) {
            var grid = this,
                isLeafName = $(grid).jqGrid('getGridParam', 'treeReader').leaf_field,
                localIdName = $(grid).jqGrid('getGridParam', 'localReader').id,
                localData,
                state,
                setCheckedStateOfChildrenItems = function (children, state) {
                    $.each(children, function () {
                        $('#' + grid.id + ' tr#' + this[localIdName] + ' td.tree-cbx > input[type=checkbox]:not(:disabled)').prop('checked', state);
                        if (!this[isLeafName]) {
                            setCheckedStateOfChildrenItems($(grid).jqGrid('getNodeChildren', this), state);
                        }
                    });
                },
                setCheckStateOfParentItems = function (local, state) {
                    var p = $(grid).jqGrid('getNodeParent', local)
                    if (typeof p != 'undefined' && p != null && p != []) {
                        var items = $.map($(grid).jqGrid('getNodeChildren', p), function (i) {
                            if (state) {
                                return !$('#' + i.id + ' td.tree-cbx > input[type=checkbox]:not(:disabled)').prop('checked') ? i : null;
                            } else {
                                return $('#' + i.id + ' td.tree-cbx > input[type=checkbox]:not(:disabled)').prop('checked') ? i : null;
                            }
                        });

                        if (items.length == 0) {
                            $('#' + p.id + ' td.tree-cbx > input[type=checkbox]:not(:disabled)').prop('checked', state);
                            setCheckStateOfParentItems(p, state);
                        }
                    }
                };

            if (e.target.nodeName === 'INPUT' && e.target.type == 'checkbox') {
                if ($(grid).data('jqParams').treeGrid === true && $(e.target).parent().hasClass('tree-cbx')) {
                    state = $(e.target).prop('checked');
                    localData = $(grid).jqGrid('getLocalRow', rowid);
                    setCheckedStateOfChildrenItems($(grid).jqGrid('getNodeChildren', localData), state);
                    setCheckStateOfParentItems(localData, state);
                }
            }


            if ($('#tblModuleList_770E4C48_body').data('jqParams').removecolumn === true && ($(e.target).parent().hasClass('remove-col') || $(e.target).parent().parent().hasClass('remove-col'))) {
                return false;
            }

            if ($(e.target).parent().hasClass('checkbox')) {
                return false;
            }

            $('#tblModuleList_770E4C48').trigger('beforeSelectRow', { rowid: rowid, e: e });
            return true;
        };

        $('#tblModuleList_770E4C48_body').data('jqParams').onSelectAll = function (aRowids, status) {
        }

        $('#tblModuleList_770E4C48_body').data('jqParams').onCellSelect = function(rowid, iCol, cellcontent, e) {
            $('#tblModuleList_770E4C48').trigger('onCellSelect', { rowid: rowid, iCol: iCol, cellcontent: cellcontent, e: e });
        }

        if ($('#tblModuleList_770E4C48_body').data('jqParams').multiselect === true && $('#tblModuleList_770E4C48_body').data('jqParams').grouping === true) {
            if ($('#tblModuleList_770E4C48_body').data('jqParams').groupingView.groupText) {
                $('#tblModuleList_770E4C48_body').data('jqParams').groupingView.groupText = $.map($('#tblModuleList_770E4C48_body').data('jqParams').groupingView.groupText, function (item) { return '<input type="checkbox" class="groupHeader" />&nbsp;' + item; });
            }
        };

        if ($('#tblModuleList_770E4C48_body').data('jqParams').treeGrid === true) {
            var param = $('#tblModuleList_770E4C48_body').data('jqParams'),
                headerexpandicon = 'tblModuleList_770E4C48_body_expand_all',
                headerlabel = $('#tblModuleList_770E4C48_body').data('jqParams').colModel[0].label;

            $('#tblModuleList_770E4C48_body').data('jqParams').treeIcons = {
                leaf: 'ui-icon-blank',
                plus: 'ui-icon-carat-1-e',
                minus: 'ui-icon-carat-1-s'
            };
            $('#tblModuleList_770E4C48_body').data('jqParams').treeReader = {
                parent_id_field: 'parent',
                level_field: 'level',
                leaf_field: 'isLeaf',
                expanded_field: 'expanded',
                loaded: 'loaded',
                icon_field: 'icon'
            }

            if (param.ExpandColumn && param.ExpandColumn != null && param.ExpandColumn != '') {
                param.ExpandColClick = true;
            }

            function SetGridExpandIconHeader() {
                return '<i class="fa fa-plus expand-all-icon" aria-hidden="true" id="' + headerexpandicon + '" title="모두보기"></i>' + headerlabel;
            };

            $('#tblModuleList_770E4C48_body').data('jqParams').colModel[0].label = SetGridExpandIconHeader();
        };

        if ($('#tblModuleList_770E4C48_body').data('jqParams').multiselect === true && $('#tblModuleList_770E4C48_body').data('jqParams').treeGrid === true) {
            var headercbx = 'tblModuleList_770E4C48_body_cbx_all';

            var cbxitem = {
                name: 'cbx',
                label: SetGridCheckboxHeader(headercbx),
                formatter: 'checkbox',
                formatoptions: { disabled: false },
                width: 25,
                fixed: true,
                align: 'center',
                sortable: false,
                classes: 'tree-cbx'
            };

            function SetGridCheckboxHeader(id) {
                return '<input role="checkbox" type="checkbox" id="' + id + '" class="tree-cbx" name="' + id + '" />';
            };

            $('#tblModuleList_770E4C48_body').data('jqParams').colModel.unshift(cbxitem);
        };

        $.map($('#tblModuleList_770E4C48_body').data('jqParams').colModel, function(col) {
            if(col.formatter == 'scriptlink') {
                col.formatter = function(cellval, opts, rowdata) {
                    var id = 'sl_' + opts.rowId + '_' + opts.pos;
                    var $a = $('<a>', { id: id, href: '#', 'data-rowid': opts.rowId, 'data-pos': opts.pos, class: 'scriptlink' }).append(cellval);
                    $('#tblModuleList_770E4C48_body').on('click', '#' + id, function() {
                        $('#tblModuleList_770E4C48').trigger('onScriptLink', { rowid: $(this).data('rowid'), pos: $(this).data('pos') });
                    });
                    return $('<div>').append($a).html();
                }
            }
        });

        if ($('#tblModuleList_770E4C48_body').data('jqParams').removecolumn == true) {
            $('#tblModuleList_770E4C48_body').off('click', 'tr.jqgrow > td.remove-col a').on('click', 'tr.jqgrow > td.remove-col a', function (e) {
                var $this = $(this),
                    rowid = $this.data('rowid');
                e.preventDefault();
                $('#tblModuleList_770E4C48').trigger('onRemoveRow', {
                    rowData: $('#tblModuleList_770E4C48_body').jqGrid('getRowData', rowid),
                    remove: function () {
                        $('#tblModuleList_770E4C48_body').jqGrid('delRowData', rowid);
                    }
                });
            });

            $('#tblModuleList_770E4C48_body').data('jqParams').colModel.push({
                name: 'removelink',
                label: ' ',
                formatter: function (cellval, opts, rowdata) {
                    var $a = $('<a>', { href: '#', 'data-rowid': opts.rowId }).append($('<i>', { class: 'fas fa-times text-danger' }));
                    return $('<div>').append($a).html();
                },
                width: 30,
                fixed: true,
                align: 'center',
                sortable: false,
                classes: 'remove-col'
            });
        };

        $('#tblModuleList_770E4C48_body').jqGrid($('#tblModuleList_770E4C48_body').data('jqParams'));

        if ($('#tblModuleList_770E4C48_body').data('jqParams').treeGrid === true) {
            $('#tblModuleList_770E4C48_body_expand_all').on('click', function () {
                if ($(this).hasClass('fa-plus')) {
                    $(this).removeClass('fa-plus').addClass('fa-minus');
                    $(this).attr('title', '모두접기');
                    $('#tblModuleList_770E4C48_body').jqGrid('expandnode_all');
                } else {
                    $(this).removeClass('fa-minus').addClass('fa-plus');
                    $(this).attr('title', '모두보기');
                    $('#tblModuleList_770E4C48_body').jqGrid('collapsenode_all');
                }
                return false;
            });
        };

        if ($('#tblModuleList_770E4C48_body').data('jqParams') != undefined && $('#tblModuleList_770E4C48_body').data('jqParams').colModel) {
            $.map($('#tblModuleList_770E4C48_body').data('jqParams').colModel, function (c) {
                if (c.align != undefined && (c.align == 'center' || c.align == 'right')) {
                    var td = $('#tblModuleList_770E4C48_body_' + c.name);
                    if (c.align == 'center' && !$(td).hasClass('center-header')) {
                        $(td).addClass('center-header').removeClass('right-header');
                    } else if (c.align == 'right' && !$(td).hasClass('right-header')) {
                        $(td).addClass('right-header').removeClass('center-header');
                    }
                }
            })
        }

        if ($('#tblModuleList_770E4C48_body').data('jqParams').multiselect === true && $('#tblModuleList_770E4C48_body').data('jqParams').treeGrid === true) {
            $('#tblModuleList_770E4C48_body_cbx_all').on('click', function (e) {
                SetHeaderCheckBoxChecked(e, $(this).is(':checked'));
                function SetHeaderCheckBoxChecked(e, checked) {
                    $.map($('#tblModuleList_770E4C48_body').jqGrid('getRowData'), function (item) {
                        $('#tblModuleList_770E4C48_body #' + item.id + ' > td.tree-cbx > input[type=checkbox]:not(:disabled)').prop('checked', checked);
                    });

                    e = e || event;
                    e.stopPropagation ? e.stopPropagation() : e.cancelBubble = false;
                }
            });
        };

        if ($('#tblModuleList_770E4C48_body').data('jqParams').bindkeys === true) {
            $('#tblModuleList_770E4C48_body').jqGrid('bindKeys');
        }

        $('#cb_tblModuleList_770E4C48_body').off('click').on('click', function (e) {
            var $this = $(this);
            $.map($('#tblModuleList_770E4C48_body tr.jqgrow'), function (r) {
                var chk = $(r).find('> td:first-child > input[type="checkbox"]');
                if (!chk.is(':disabled')) {
                    chk.prop('checked', $this.is(':checked'));
                }
            })

            if (!$this.is(':checked')) {
                $('#tblModuleList_770E4C48_body').jqGrid('resetSelection');
            }

            $('#tblModuleList_770E4C48').trigger('onAllCheck-click', this.checked);
        });

        $('#tblModuleList_770E4C48').on('gridresize', function () {
            var width = $(this).parent().width();
            if (width > 0) {
                $('#tblModuleList_770E4C48_body').setGridWidth(width);
            }
        });
    });

    function responseGrid(ctrl) {
        if (ctrl) {
            if ($(ctrl).attr('role') === 'presentation') {
                return ctrl;
            } else {
                if ($('#' + $(ctrl).attr('id') + '_body').attr('role') === 'presentation') {
                    return $('#' + $(ctrl).attr('id') + '_body');
                }
            }
        }
        return ctrl;
    }
</script>

    </div>
</div>



<script>
    $(function () {
        $('#tblModuleList_770E4C48').on('beforeSelectRow', function (option, e) {
            $('#tblModuleList_770E4C48_body').jqGrid('setSelection', e.rowid, false);

            var ids = $('#tblModuleList_770E4C48_body').jqGrid('getGridParam', "selarrrow");

            var rows = [];

            for (var i = 0; i < ids.length; i++) {
                var ret = $('#tblModuleList_770E4C48_body').jqGrid('getRowData', ids[i]);

                if ("1" != ret.prod_check) {
                    rows.push(ids[i]);
                }
            }

            $('#tblModuleList_770E4C48_body').jqGrid("resetSelection");

            if (rows.length == "0") {
                $("#delBtn").hide();
            } else {
                $("#delBtn").show();
            }


            for (var i = 0; i < rows.length; i++) {
                $("#jqg_tblModuleList_770E4C48_body_" + rows[i]).prop("checked", true);
                $('#tblModuleList_770E4C48_body').jqGrid('setSelection', rows[i], false);
            }

            $('#tblModuleList_770E4C48_body').jqGrid('setSelection', e.rowid, false);
        });



        $.fn.selectCheck = function () {
            var result = $('#tblModuleList_770E4C48_body').jqGrid('getGridParam', "selarrrow");
            return result;
        }

        $('#jqgh_tblModuleList_770E4C48_body_cb').click(function () {
            var ids = $.fn.selectCheck();
            console.log(ids.length);

            if (ids.length == "0") {
                var idArray = $('#tblModuleList_770E4C48_body').getDataIDs();

                for (var i = 0; i < idArray.length; i++) {
                    var ret = $('#tblModuleList_770E4C48_body').getRowData(idArray[i]);

                    if ("0" == ret.prod_check) {
                        $('#tblModuleList_770E4C48_body').jqGrid('setSelection', idArray[i], false);
                    }
                }

                var result = $.fn.selectCheck()

                if (result.length != "0") {
                    $("#delBtn").show();
                }
            } else {
                var idArray = $('#tblModuleList_770E4C48_body').getDataIDs();

                for (var i = 0; i < idArray.length; i++) {
                    if ($("input:checkbox[id='jqg_tblModuleList_770E4C48_body_" + idArray[i] + "']").is(":checked")) {
                        $('#tblModuleList_770E4C48_body').jqGrid("resetSelection", idArray[i], false);
                    }
                }

                $("#delBtn").hide();
            }
        });

        $.fn.reloadJqgridTable = function () {
            $('#tblModuleList_770E4C48').trigger('reload', {
                pcode: $('#sel_pcode_770E4C48').val(),
                stext: $('#txt_stext_770E4C48').val()
            });
        }

        $('#sel_pcode_770E4C48').change(function () {
            var doc = $('#sel_pcode_770E4C48').val();
            $.fn.reloadJqgridTable();
        });




        $.fn.fmatter.showMailingType = function (cellvalue, options, rowObject) {
            if (cellvalue == 1) {
                return "조직";
            } else if (cellvalue == 2) {
                return "사용자";
            } else {
                return cellvalue;
            }
        };
    });



    var vm770E4C48 = {
        action: {
            OnClickRegister: function () {
                location.href = '/mailingmgmt/list/register';
            },

            OnClickRemove: function() {
                if (confirm('삭제하시겠습니까?')) {
                    $('#tblModuleList_770E4C48').jqGrid("selecteditems", function (selected) {
                        var selectedItems = [];
                        selected.forEach(function (elem) {
                            selectedItems.push({
                                prod_code: elem.prod_code,
                                domain_code: elem.domain_code,
                                target_type: elem.target_type,
                                target_code: elem.target_code
                            });
                        });

                        $.ajax({
                            type: 'DELETE',
                            url: '/mailingmgmt/delete',
                            data: JSON.stringify(selectedItems),
                            contentType: 'application/json; charset=utf-8',
                            success: function (result) {
                                BaseScriptUtil.showToastrSuccess("정상적으로 삭제되었습니다.", setTimeout(() => {
                                    location.href = '/mailingmgmt/list';
                                }, 1000)
                                );
                            }
                        });
                    });
                }
            }

        }
    };



</script>

</div>

<script>
    $(function () {
        if ($('#content').hasClass('nets-content-tree')) {
            $('#content').removeClass('nets-content-tree');
        }
    });
</script>
            </div>
                <div id="footer" class="app-footer mx-0 px-0">
                    &copy; 1998-2023 By NETS Co. All Rights Reserved
                </div>
        </div>
        <!-- END #content -->
    </div>
    <!-- #modal-basic -->
    <div class="modal fade" id="modal-basic">
        <div class="modal-dialog modal-dialog-centered modal-custom-div">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title"></h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                </div>
                <div class="modal-body">
                </div>
                <div class="modal-footer">
                    <a href="javascript:;" class="btn btn-white" data-bs-dismiss="modal">닫기</a>
                    <button class="btn btn-primary" data-type="ok">확인</button>
                </div>
            </div>
        </div>
    </div>
    <!-- #modal-alert -->
    <div class="modal fade" id="modal-alert" data-bs-backdrop="static" data-bs-keyboard="true">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title"></h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                </div>
                <div class="modal-body">
                    <div class="alert alert-danger text-break" style="white-space:pre-wrap"></div>
                </div>
                <div class="modal-footer">
                    <a href="javascript:;" class="btn btn-white" data-bs-dismiss="modal">닫기</a>
                </div>
            </div>
        </div>
    </div>
    <!-- #modal-message -->
    <div class="modal modal-message fade" id="modal-message">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title"></h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                </div>
                <div class="modal-body text-break" style="white-space:pre-wrap">
                </div>
                <div class="modal-footer">
                    <a href="javascript:;" class="btn btn-white" data-bs-dismiss="modal">닫기</a>
                </div>
            </div>
        </div>
    </div>
    <!-- #modal-message-error -->
    <div class="modal modal-message fade" id="modal-message-error" data-bs-backdrop="static">
        <div class="modal-dialog modal-dialog-centered">
            <div class="modal-content">
                <div class="modal-header">
                    <h4 class="modal-title"></h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-hidden="true"></button>
                </div>
                <div class="modal-body">
                    <div class="alert alert-danger text-break" style="white-space:pre-wrap">
                    </div>
                </div>
                <div class="modal-footer">
                    <a href="javascript:;" class="btn btn-white" data-bs-dismiss="modal">닫기</a>
                </div>
            </div>
        </div>
    </div>
    <!-- #offcanvas start-->
    <div class="offcanvas offcanvas-start">
        <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasLabel"></h5>
            <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"></button>
        </div>
        <div class="offcanvas-body">
        </div>
    </div>
    <!-- #offcanvas end-->
    <div class="offcanvas offcanvas-end">
        <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasLabel"></h5>
            <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"></button>
        </div>
        <div class="offcanvas-body">
        </div>
    </div>
    <!-- #offcanvas bottom-->
    <div class="offcanvas offcanvas-bottom">
        <div class="offcanvas-header">
            <h5 class="offcanvas-title" id="offcanvasLabel"></h5>
            <button type="button" class="btn-close text-reset" data-bs-dismiss="offcanvas"></button>
        </div>
        <div class="offcanvas-body">
        </div>
    </div>
    <footer>
        <!-- HTML 렌더링 중 script를 만나면 브라우저는 렌더링을 멈추고 script에 대한 해석을 실시. 대부분의 경우 body의 마지막에 스크립트를 위치 시키도록 권장 -->
        

    <script src="/_content/Nets.O365M.Web.Platform/lib/jqgrid/js/jquery.jqGrid.js"></script>
        <script src="/_content/Nets.O365M.Web.Platform/lib/jqgrid/js/i18n/grid.locale-KR.js"></script>
    <script src="/_content/Nets.O365M.Web.Platform/lib/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
    <script src="/_content/Nets.O365M.Web.Platform/lib/bootstrap-daterangepicker/moment.min.js"></script>
    <script src="/_content/Nets.O365M.Web.Platform/lib/bootstrap-daterangepicker/daterangepicker.js"></script>
        <script src="/_content/Nets.O365M.Web.Platform/lib/bootstrap-datepicker/locales/bootstrap-datepicker.KR.min.js"></script>
    <script src="/_content/Nets.O365M.Web.Platform/lib/bootstrap-sweetalert/sweetalert.js"></script>
    <script src="/_content/Nets.O365M.Web.Platform/lib/jquery-validate/jquery.validate.js"></script>
        <script src="/_content/Nets.O365M.Web.Platform/lib/jquery-validate/localization/messages_ko.js"></script>
    <script src="/_content/Nets.O365M.Web.Platform/lib/jstree/jstree.min.js"></script>
    <script src="/_content/Nets.O365M.Web.Platform/lib/toastr.js/toastr.min.js"></script>
    <script src="/_content/Nets.O365M.Web.Platform/lib/color-admin/js/app.js"></script>
    <script src="/_content/Nets.O365M.Web.Platform/lib/color-admin/js/theme/default.js"></script>
    <script src="/_content/Nets.O365M.Web.Platform/lib/select2/js/select2.js"></script>


        <template id="_loading_indicator">
    <div class="text-center text-primary">
        <div class="spinner-border" role="status">
            <span class="sr-only">Loading...</span>
        </div>
    </div>
</template>
<script>
    $(function () {
        //Color-Admin V5.0 use auto initialize by itself.
        //App.init();

        //현재 scope 내에서만 유효한 initialize 용 모델
        const initScriptModel = {
            initJquery: function () {
                $.xhrPool = [];

                $.xhrPoolAbortAll = function () {
                    $($.xhrPool).each(function (idx, jqXHR) {
                        jqXHR.abort();
                    });
                    $.xhrPool = [];
                };

                $.ajaxSetup({
                    cache: false,
                    xhrFields: {
                        widthCredentials: false
                    }
                });

                $.support.cors = true;
                $.ajaxSettings.traditional = true;

                //jquery 3.3.1 의 전역 오류는 ajaxError 핸들러에 의해 처리
                $(document).ajaxError(function (event, jqXHR, ajaxSettings, thrownError) {
                    BaseScriptUtil.showAjaxError(event, jqXHR, ajaxSettings, thrownError);
                });
            },
            initJsTree: function () {
                if ($.jstree.plugins) {
                    $.jstree.plugins.treegrid = function (option, parent) {
                        this.redraw_node = function (obj, deep, callback, force_draw) {
                            let $tree = this;
                            obj = parent.redraw_node.call($tree, obj, deep, callback, force_draw);

                            if ($tree.settings.treegrid && $tree.settings.treegrid.columns && $tree.settings.treegrid.columns.length > 1) {
                                let row = $('<div class="row">');
                                $.map($tree.settings.treegrid.columns, function (col) {
                                    let size = $.fmatter.isNumber(col.Size) ? ('-' + col.Size) : '';
                                    if (col.id == 'name') {
                                        row.append($('<div class="col-md' + size + '">').append(obj.childNodes[2].childNodes));
                                    } else {
                                        row.append($('<div class="col-md' + size + '">').append($tree.get_node(obj).data[col.id]));
                                    }
                                });
                                $(obj.childNodes[2]).append(row[0]);
                            }
                            return obj;
                        };
                    };
                }
            },
            initIssueList: function () {
                $.fn.issue = function (option) {
                    var $this = $(this),
                        $i = {
                            params: function (val) {
                                if (val != undefined) {
                                    $this.data('params', val);
                                } else {
                                    return $this.data('params');
                                }
                            },
                            rows: function () {
                                return $this.data('rows');
                            },
                            appendRows: function () {
                                $i.params().page++;
                                $.post($i.params().url, { model: JSON.stringify($i.params()) }, function (text, status) {
                                    if (status == 'success') {
                                        $this.find('tbody').append(text);
                                        var tmp = $('<div />').append(text);
                                        $.map(tmp.find('tr'), function (row) {
                                            $i.addData(row);
                                        });
                                        $('#btn_add_items_' + $this.attr('id')).prop('disabled', ($this.find('tr').length == 0 || $this.find('tr').is('.last-row')));
                                    }
                                });
                            },
                            addData: function (row) {
                                if ($i.rows() == undefined) {
                                    $this.data('rows', []);
                                }
                                var addRow = { rowid: $(row).data('content') };
                                $.map($(row).find('td'), function (col) {
                                    if ($(col).attr('data-col') && $(col).attr('data-value')) {
                                        addRow[$(col).data('col')] = $(col).data('value');
                                    }
                                });
                                $i.rows().push(addRow);
                            },
                            search: function (t) {
                                $i.params().page = 1;
                                $i.reload({ stext: t });
                            },
                            reload: function (p) {
                                var params = $.extend({ model: JSON.stringify($i.params()) }, (p || {}));
                                $this.find('tbody').load($i.params().url, params, function () {
                                    $.map($this.find('tr'), function (row) {
                                        $i.addData(row);
                                    });

                                    $('#btn_add_items_' + $this.attr('id')).prop('disabled', ($this.find('tr').length == 0 || $this.find('tr').is('.last-row')));
                                });
                            },
                            showMessage: function (rowid, c, m) {
                                var idx = $i.params().cols.findIndex(function (x) { return x.name == c; }),
                                    url = $i.params().cols[idx].linkoption.url,
                                    params = $i.params().cols[idx].linkoption.params,
                                    msg = m;

                                if (params != undefined && params != null && params != '') {
                                    var rowidx = $i.rows().findIndex(function (r) { return r.rowid == rowid; }),
                                        row = $i.rows()[rowidx];

                                    msg = row[params[0]];
                                }

                                ShowModal(url, $this.attr('id') + '_pop', { msg: msg });
                            }
                        };

                    if (option == true) return $i;
                    if (option == undefined) return $this;

                    if (option.url != undefined && option.url != '' && option.url != null && option.loaded == false) {
                        $i.params(option);
                        $i.reload();
                    }
                    return $this;
                };
            },
            initJqGrid: function () {
                $.fn.jqGrid.selecteditems = function (callback) {
                    var $grid = responseGrid(this);
                    if ($grid.data('jqParams').multiselect === true && $grid.data('jqParams').treegrid === true) {
                        var items = $('#' + $grid.attr('id') + ' tr > td.tree-cbx > input[type=checkbox]:checked');
                        if (items.length == 0) {
                            callback([]);
                        } else {
                            $grid.jqGrid('getTreeGridRowData', null, callback);
                        }
                    } else if ($grid.data('jqParams').multiselect === true) {
                        var items = $('#' + $grid.attr('id') + ' tr.jqgrow > td:first-child > input[type=checkbox]:checked');
                        if (items.length != 0) {
                            if ($.type(callback) === 'function') {
                                callback($.map(items, function (i) {
                                    return $grid.jqGrid('getRowData', $(i).parent().parent().attr('id'));
                                }));
                            } else {
                                return $.map(items, function (i) {
                                    return $grid.jqGrid('getRowData', $(i).parent().parent().attr('id'));
                                });
                            }
                        } else {
                            if ($.type(callback) === 'function') {
                                callback([]);
                            } else {
                                return [];
                            }
                        }
                    } else {
                        if ($.type(callback) === 'function') {
                            callback($grid.jqGrid('getRowData', $grid.jqGrid('getGridParam', 'selrow')));
                        } else if ($.type(callback) === 'undefined') {
                            return $grid.jqGrid('getRowData', $grid.jqGrid('getGridParam', 'selrow'));
                        }
                    }
                };

                $.fn.jqGrid.getParentItems = function (items) {
                    var $grid = responseGrid(this);
                    var rtnval = [];
                    $.map(items, function (i) {
                        rtnval.push(i);
                        var p = $grid.jqGrid('getNodeParent', i);
                        while (p) {
                            if ($.inArray(p, rtnval) < 0) {
                                rtnval.unshift(p);
                            }
                            p = $grid.jqGrid('getNodeParent', p);
                        }
                    });
                    return rtnval;
                };

                $.fn.jqGrid.expandnode_all = function () {
                    var $grid = responseGrid(this),
                        wait = function (ms) {
                            var deferred = $.Deferred();
                            setTimeout(function () {
                                deferred.resolve();
                            }, ms);
                            return deferred.promise();
                        },
                        getloadedcheck = function () {
                            var deferred = $.Deferred();

                            var items = $.map($grid.jqGrid('getDataIDs'), function (v) {
                                return $grid.jqGrid('getLocalRow', v);
                            });

                            var chk = $.map(items, function (i) {
                                if (i.isLeaf === false) {
                                    if ($grid.jqGrid('getNodeChildren', i).length === 0 || i.loaded === false) {
                                        return i;
                                    } else {
                                        return null;
                                    }
                                } else {
                                    return null;
                                }
                            }).length === 0;

                            if (chk) {
                                deferred.resolve();
                            } else {
                                deferred.reject();
                            }

                            return deferred.promise();
                        },
                        callbackdone = function () {
                            $.map($grid.jqGrid('getDataIDs'), function (v) {
                                var item = $grid.jqGrid('getLocalRow', v);
                                if (item.isLeaf === false) {
                                    expandnode(item.id);
                                }
                            });
                        },
                        callbackfail = function () {
                            wait(100).done(function () {
                                var items = $.map($grid.jqGrid('getDataIDs'), function (v) {
                                    return $grid.jqGrid('getLocalRow', v);
                                });

                                $.map(items, function (i) {
                                    if (i.isLeaf === false && i.loaded === false) {
                                        expandnode(i.id);
                                    } else {
                                        var child = $grid.jqGrid('getNodeChildren', $grid.jqGrid('getLocalRow', i.id));
                                        $.map(child, function (i) {
                                            expandnode(i.id);
                                        });
                                    }
                                });
                                getloadedcheck().done(callbackdone).fail(callbackfail);
                            });
                        },
                        expandnode = function (id) {
                            var p = $grid.jqGrid('getLocalRow', id);
                            if (p.isLeaf === false && p.expanded === false) {
                                $('#' + $grid.attr('id') + ' tr#' + id + ' > td div.treeclick').triggerHandler('click');
                            }
                        };

                    getloadedcheck().done(callbackdone).fail(callbackfail);
                };

                $.fn.jqGrid.collapsenode_all = function () {
                    var $grid = responseGrid(this);
                    $.map($('#' + $grid.attr('id') + ' div.treeclick.tree-minus'), function (i) {
                        $(i).trigger('click');
                    });
                };

                $.fn.jqGrid.getTreeGridRowData = function (id, callback) {
                    var $grid = responseGrid(this),
                        wait = function (ms) {
                            var deferred = $.Deferred();
                            setTimeout(function () {
                                deferred.resolve();
                            }, ms);
                            return deferred.promise();
                        },
                        getCheckedItems = function () {
                            var deferred = $.Deferred();

                            var items = $.map($('#' + $grid.attr('id') + ' tr > td.tree-cbx > input[type=checkbox]:checked'), function (v) {
                                return $grid.jqGrid('getLocalRow', $(v).parent().parent().attr('id'));
                            });

                            var chk = $.map(items, function (i) {
                                if (i.isLeaf === false) {
                                    if ($grid.jqGrid('getNodeChildren', i).length === 0 || i.loaded === false) {
                                        return i;
                                    } else {
                                        return null;
                                    }
                                } else {
                                    return null;
                                }
                            }).length === 0;

                            if (chk) {
                                deferred.resolve();
                            } else {
                                deferred.reject();
                            }

                            return deferred.promise();
                        },
                        callbackitemsdone = function () {
                            var vals = $.map($('#' + $grid.attr('id') + ' tr > td.tree-cbx > input[type=checkbox]:checked'), function (v) {
                                return $grid.jqGrid('getLocalRow', $(v).parent().parent().attr('id'));
                            });
                            callback(vals);
                        },
                        callbackitemsfail = function () {
                            wait(100).done(function () {
                                var vals = $.map($('#' + $grid.attr('id') + ' tr > td.tree-cbx > input[type=checkbox]:checked'), function (v) {
                                    return $grid.jqGrid('getLocalRow', $(v).parent().parent().attr('id'));
                                });

                                $.map(vals, function (i) {
                                    if (i.isLeaf === false && i.loaded === false) {
                                        expandnode(i.id);
                                    } else {
                                        var child = $grid.jqGrid('getNodeChildren', $grid.jqGrid('getLocalRow', i.id));
                                        $.map(child, function (i) {
                                            expandnode(i.id);
                                        });
                                    }
                                });
                                getCheckedItems().done(callbackitemsdone).fail(callbackitemsfail);
                            });
                        },
                        expandnode = function (id) {
                            var p = $grid.jqGrid('getLocalRow', id);
                            if (p.isLeaf === false && p.expanded === false) {
                                $('#' + $grid.attr('id') + ' tr#' + id + ' > td div.treeclick').triggerHandler('click');
                            }
                        };

                    getCheckedItems().done(callbackitemsdone).fail(callbackitemsfail);
                };

                $.fn.fmatter.checkboxtree = function (cellval, opts, rowdata) {
                    return $.fn.fmatter.checkbox(cellval, opts, rowdata);
                };

                $.fn.fmatter.mvclink = function (cellval, opts, rowdata) {
                    if ((opts.colModel['formatoptions'] && opts.colModel['formatoptions']['baseLinkUrl'])
                        || ($.fmatter.isString(cellval) || $.fmatter.isNumber(cellval))) {
                        var op = {
                            baseLinkUrl: opts.colModel['formatoptions']['baseLinkUrl'], paramNames: opts.colModel['formatoptions']['paramNames'], script: opts.colModel['formatoptions']['script']
                        }, linkUrl;

                        if (op.script)
                            eval(op.script);

                        linkUrl = $.validator.format(op.baseLinkUrl)($.map(op.paramNames, function (item) { return rowdata[item]; }));

                        var page = $("#" + opts.gid).getGridParam('page');
                        if (page) {
                            if (linkUrl.indexOf('?') < 0) {
                                linkUrl += '?page=' + page;
                            }
                            else {
                                linkUrl += '&page=' + page;
                            }
                        }

                        return '<a href=\"' + linkUrl + '\" class=\"link-info\">' + cellval + '</a>';
                    }

                    return $.fn.fmatter.defaultFormat(cellval, opts);
                };

                $.fn.fmatter.mvcpopup = function (cellval, opts, rowdata) {
                    var op = { baseLinkUrl: opts.baseLinkUrl, paramNames: opts.paramNames, script: opts.script }, linkUrl, query;
                    if (opts.colModel !== undefined && opts.colModel.formatoptions !== undefined) {
                        op = $.extend({}, op, opts.colModel.formatoptions);
                    }

                    if (op.script)
                        eval(op.script);

                    query = $.map(op.paramNames, function (item) { return item.toLowerCase() + '=' + rowdata[item]; }).join('&');

                    linkUrl = $.validator.format(op.baseLinkUrl)($.map(op.paramNames, function (item) { return rowdata[item]; }));

                    if (query != null && query != '')
                        linkUrl += '?' + query;

                    if ($.fmatter.isString(cellval) || $.fmatter.isNumber(cellval)) {	//add this one even if its blank string
                        return '<a href=\"#\" class=\"link-info\" onclick=\"ShowModal(\'' + linkUrl + '\', \'pop_jq_cell_' + opts.rowId + '\');\"><div style="width:100%; height:100%;">' + cellval + '</div></a>';
                    }

                    return $.fn.fmatter.defaultFormat(cellval, opts);
                };

                $.fn.fmatter.buttoncell = function (cellval, opts, rowdata) {
                    var op = { label: opts.label }, linkUrl;
                    if (opts.colModel !== undefined && opts.colModel.formatoptions !== undefined) {
                        op = $.extend({}, op, opts.colModel.formatoptions);
                    }

                    return '<button type=\"button\" class=\"btn btn-default btn-xs\" data-content=\"' + opts.rowId + '\">' + op.label + '</button>';
                };

                $.fn.fmatter.alink = function (cellval, opts, rowdata) {
                    return '<a class=\"link-info\" href=\"#\" data-content=\"' + opts.rowId + '\">' + cellval + '</button>';
                };

                $.fn.fmatter.selectcss = function (cellval, opts) {
                    for (var i = 0, count = opts.colModel.formatoptions.length; i < count; i++) {
                        var op = { cssName: opts.cssName, value: opts.value, text: opts.text };
                        if (opts.colModel !== undefined && opts.colModel.formatoptions[i] !== undefined) {
                            op = $.extend({}, op, opts.colModel.formatoptions[i]);
                        };

                        if (($.fmatter.isString(cellval) || $.fmatter.isNumber(cellval) || $.fmatter.isBoolean(cellval)) && cellval == op.value) {	//add this one even if its blank string
                            return '<span class=\"' + (op.cssName == undefined || op.cssName == null ? '' : op.cssName) + '\">' + op.text + '</span>';
                        }
                    };

                    return $.fn.fmatter.defaultFormat(cellval, opts);
                };

                $.fn.fmatter.validcss = function (cellval, opts, rowdata) {
                    var op = {};
                    if (opts.colModel !== undefined && opts.colModel.formatoptions !== undefined) {
                        op = opts.colModel.formatoptions;
                    };

                    return '<span class=\"' + (rowdata[op[0]] < cellval ? 'text-danger' : '') + '\">' + cellval + '</span>';
                };

                $.fn.fmatter.selecticon = function (cellval, opts) {
                    for (var i = 0, count = opts.colModel.formatoptions.length; i < count; i++) {
                        var op = { cssName: opts.cssName, value: opts.value, text: opts.text };
                        if (opts.colModel !== undefined && opts.colModel.formatoptions[i] != undefined) {
                            op = $.extend({}, op, opts.colModel.formatoptions[i]);
                        };

                        if (($.fmatter.isString(cellval) || $.fmatter.isNumber(cellval) || $.fmatter.isBoolean(cellval)) && cellval == op.value) {	//add this one even if its blank string
                            return '<i class=\"' + (op.cssName == undefined || op.cssName == null ? '' : op.cssName) + '\" title=\"' + (op.text == undefined || op.text == null ? op.value : op.text) + '\" ></i>';
                        }
                    };

                    return $.fn.fmatter.defaultFormat(cellval, opts);
                };

                $.fn.fmatter.icon = function (cellval, opts) {
                    if ($.fmatter.isString(cellval)) {
                        return '<i class=\"' + cellval + '\" title=\"' + cellval + '\" ></i>';
                    } else {
                        return $.fn.fmatter.defaultFormat(cellval, opts);
                    }
                };

                $.fn.fmatter.progressbar = function (cellval, opts) {
                    if ($.fmatter.isNumber(cellval)) {
                        return '<div class="progress" title = \"' + cellval + '\%" ><div style=\"width: ' + cellval + '%;\" class=\"progress-bar\" ></div></div>';
                    } else {
                        return $.fn.fmatter.defaultFormat(cellval, opts);
                    }
                }

                $.fn.fmatter.selecthtml = function (cellval, opts, rowdata) {
                    for (var i = 0, count = opts.colModel.formatoptions.length; i < count; i++) {
                        var op = { html: opts.html, value: opts.value };
                        if (opts.colModel !== undefined && opts.colModel.formatoptions[i] != undefined) {
                            op = $.extend({}, op, opts.colModel.formatoptions[i]);
                        }

                        if (($.fmatter.isString(cellval) || $.fmatter.isNumber(cellval) || $.fmatter.isBoolean(cellval)) && cellval == op.value) {	//add this one even if its blank string
                            return op.html;
                        }
                    }

                    return $.fn.fmatter.defaultFormat(cellval, opts);
                };

                $.fn.fmatter.script = function (cellval, opts, rowdata) {
                    if (opts.colModel.formatoptions && opts.colModel.formatoptions.script && opts.colModel.formatoptions.script.length > 0) {
                        eval(opts.colModel.formatoptions.script);
                        return cellval;
                    }
                    else {
                        return $.fn.fmatter.defaultFormat(cellval, opts);
                    }
                };

                $.fn.fmatter.collapse = function (cellval, opts, rowdata) {
                    if (cellval) {
                        if (opts.colModel.formatoptions && opts.colModel.formatoptions.script && opts.colModel.formatoptions.script.length > 0) {
                            eval(opts.colModel.formatoptions.script);
                        }

                        //row id로 사용될 값에 '\', '.', ' '(공백) 이 들어있는 경우 id값으로 식별 불가하므로 제거.
                        var rowid = opts.rowId.replace(/\\/g, '_').replace(/\./g, '_').replace(/\ /g, '_');
                        var result = '<table style="height:100%;"><tbody><tr>';
                        result += '<td style="border:none; vertical-align:middle; cursor: pointer;" onclick="$(this).next().show();$(this).hide();" data-toggle="collapse" data-target="#_clps_' + rowid + '_' + opts.pos + '"><i class="fa fa-plus-square fa-lg text-success"/></td>';
                        result += '<td style="display:none; border:none; vertical-align:middle; cursor: pointer;" onclick="$(this).prev().show();$(this).hide();" data-toggle="collapse" data-target="#_clps_' + rowid + '_' + opts.pos + '"><i class="fa fa-minus-square fa-lg"/></td>';

                        result += '<td style="border:none; vertical-align:middle;">';
                        result += '<div id="_clps_' + rowid + '_' + opts.pos + '" class="collapse" style="white-space:normal;padding:10px 10px 10px 0px;">' + cellval + '</div>';
                        result += '</td></tr></tbody></table>'

                        return result;
                    }
                    else
                        return $.fn.fmatter.defaultFormat(cellval, opts);
                };

                $.fn.fmatter.ellipsis = function (cellval, opts, rowdata) {
                    if (cellval && opts.colModel.width && opts.colModel.fixed) {
                        //width 로 지정된 수치보다 실제 컬럼의 길이가 약간 작으므로 해당 값을 반영하여 15px정도를 제외하여 div 크기를 정한다.
                        return '<div class="text-ellipsis" style="width: ' + (opts.colModel.width - 15) + 'px">' + cellval + '</div>'
                    }
                    else
                        return $.fn.fmatter.defaultFormat(cellval, opts);
                };

                //창 크기 변화에 따른 jqgrid 크기 조절
                $(window).bind('resize', function () {
                    $('.custom-jqgrid').trigger('gridresize');
                });

                //Color-Admin panel expand/collapse event
                $(document).on('click', '[' + app.panel.toggle.expand.attr + ']', function (e) {
                    $('.custom-jqgrid').trigger('gridresize');
                });
            },
            initBootstrapDatetimePicker: function () {
                $.fn.datepicker.defaults.language = '';
            },
            initToastr: function () {
                toastr.options = {
                    closeButton: true,
                    progressBar: true,
                    showMethod: 'slideDown',
                    timeOut: 3000
                };
            },
            initJqueryValidate: function () {
                //jquery-validate 의 기본 오류클래스인 .error 가 color-admin과 충둘을 일으키므로 bootstrap의 validation class로 변경
                jQuery.validator.setDefaults({
                    errorClass: "is-invalid",
                    errorPlacement: function (error, element) {
                        //error : 오류메시지
                        //element : validate 대상 control
                        //오류 메시지 라벨이 중복으로 추가되지 않도록 다음 엘리먼트를 검사한다.
                        if (element.next('label.invalid-feedback').length == 0) {
                            //error class로 지정된 값은 오류 메시지 element에도 동일하게 적용되고 is-invalid class가 label에 적용되면 정상적으로 표시되지 않으므로 제거하여 적절한 클래스를 추가한다.
                            error.removeClass('is-invalid').addClass('invalid-feedback').insertAfter(element);
                        }
                    }
                });
            }
        }

        initScriptModel.initJquery();
        initScriptModel.initJsTree();
        initScriptModel.initIssueList();
        initScriptModel.initJqGrid();
        initScriptModel.initBootstrapDatetimePicker();
        initScriptModel.initToastr();
        initScriptModel.initJqueryValidate();
    });

    (function ($, undefined) {
        'use strict';

        $.fn.simplelist = function (option) {
            var $this = $(this),
                $s = {
                    params: function (val) {
                        if (val != undefined) {
                            $this.data('params', val);
                        } else {
                            return $this.data('params');
                        }
                    },
                    rows: function () {
                        return $.map($this.find('tbody > tr'), function (r) { return $(r).data('row'); });
                    },
                    selectedItems: function () {
                        return $.map($this.find('tbody > tr'), function (r) {
                            if ($(r).find('[type=checkbox]').is(':checked')) {
                                return $(r).data('row');
                            }
                        });
                    },
                    updateRow: function (rowid, data) {
                        var $row = $this.find('tbody > #' + rowid);
                        $.each(data, function (key, val) {
                            $row.find('[data-col="' + key + '"]').html(val);
                            $row.data('row')[key] = val;
                        });
                    },
                    appendRow: function (row) {
                        var $row = $('<tr>', { id: row.rowid }),
                            $edita = $('<a>', { href: '#' }).append($('<i>', { class: 'fas fa-edit edit-icon', title: '수정'})).data('target', row.rowid),
                            $removea = $('<a>', { href: '#' }).append($('<i>', { class: 'fas fa-times text-danger', title: 'btn_delete' })).data('target', row.rowid);

                        $edita.click(function (e) {
                            var $cell = $(this).parent(),
                                $row = $cell.parent();
                            $this.trigger('onSelectEditCol', { rowid: $row.attr('id'), data: $row.data('row') });
                            e.preventDefault();
                        });

                        $removea.click(function (e) {
                            var $cell = $(this).parent(),
                                $row = $cell.parent();
                            $s.removeRow($row.attr('id'));
                            e.preventDefault();
                        });

                        $row.attr('role', 'row');
                        $.map($s.params().columns, function (c) {
                            if (!c.hidden) {
                                $row.append($('<td>', { 'data-col': c.columnid }).html(row.data[c.columnid]));
                            }
                        });

                        if ($s.params().edit) {
                            $row.append($('<td>', { class: 'edit-col' }).append($edita));
                        }

                        if ($s.params().remove) {
                            $row.append($('<td>', { class: 'remove-col' }).append($removea));
                        }

                        $row.data('row', row.data);
                        $this.find('tbody').append($row);
                    },
                    reload: function (p) {
                        $s.disableControls(true);
                        var params = $.extend({ model: JSON.stringify($s.params()) }, (p || {}));
                        var loader = BaseScriptUtil.getLoadIndicator();
                        $this.find('tbody > tr.loading-row > td').append(loader);
                        $this.find('tbody').load($s.params().url, params, function () {
                            $this.find('tbody > tr.loading-row').remove();

                            $this.find('tbody > tr > td.remove-col > a').click(function (e) {
                                var $cell = $(this).parent(),
                                    $row = $cell.parent();
                                $s.removeRow($row.attr('id'));
                                e.preventDefault();
                            });
                        });
                    },
                    removeRow: function (rowid) {
                        var rowdata = $('#' + rowid).data('row');
                        if ($s.params().removeconfirm) {
                            ShowConfirm('선택된 항목을 삭제하시겠습니까?', 'btn_delete', 'error', function () {
                                $this.find('tbody > #' + rowid).remove();
                                $this.trigger('onSelectRemoveCol', { rowid: rowid, data: rowdata });
                            });
                        } else {
                            $this.find('tbody > #' + rowid).remove();
                            $this.trigger('onSelectRemoveCol', { rowid: rowid, data: rowdata });
                        }
                        return false;
                    },
                    disableControls: function (flag) {
                        if (flag) {
                            $this.find('input[type="button"]').attr('disabled', 'disabled');
                            $this.find('input[type="checkbox"]').attr('disabled', 'disabled');
                            $this.find('button').attr('disabled', 'disabled');
                            $this.find('a[role="button"]').attr('disabled', 'disabled');
                            $this.find('tbody > tr').addClass('disabled');
                        } else {
                            $this.find('input[type="button"]').removeAttr('disabled');
                            $this.find('input[type="checkbox"]').removeAttr('disabled');
                            $this.find('button').removeAttr('disabled');
                            $this.find('a[role="button"]').removeAttr('disabled');
                            $this.find('tbody > tr').removeClass('disabled');
                        }
                    }
                };

            if (option == true) return $s;
            if (option == undefined) return $this;

            if (option.url != undefined && option.url != '' && option.url != null && option.loaded == false) {
                $s.params(option);
                $s.reload();
            }

            if (option.loaded == true && $this.find('tbody > tr.loading-row').length > 0) {
                $s.params(option);
                $this.find('tbody > tr.loading-row').remove();
                $this.find('tbody > tr > td.remove-col > a').click(function (e) {
                    var $cell = $(this).parent(),
                        $row = $cell.parent();
                    $s.removeRow($row.attr('id'));
                    e.preventDefault();
                });
            }

            return $this;
        };
    })(jQuery);

    const BaseScriptUtil = {
        showAlert: function (msg, title, type, confirm, callback) {
            if (type == undefined || (type !== 'warning' && type !== 'error' && type !== 'success')) {
                type = 'info';
            }

            if (confirm == undefined || typeof (confirm) !== typeof (true)) {
                confirm = false;
            }

            let btnClass = 'btn-info width-100';
            if (type == 'warning') {
                btnClass = 'btn-warning width-100';
            }
            else if (type == 'success') {
                btnClass = 'btn-success width-100';
            }
            else if (type == 'error') {
                btnClass = 'btn-danger width-100';
            }

            let cancelBtnClass = 'btn-default width-100';

            swal({
                title: title,
                text: msg,
                animation: false,
                type: type,
                showCancelButton: confirm,
                confirmButtonClass: btnClass,
                confirmButtonText: confirm ? '예' : '확인',
                cancelButtonText: '아니오',
                cancelButtonClass: cancelBtnClass
            },
                function (flag) {
                    if (typeof callback == 'function') {
                        if (flag == true) {
                            callback();
                            //$('body > .sweet-alert').remove();
                        }
                    }
                });
        },
        showAlertInfo: function (msg, title = 'Info.', confirm, callback) {
            this.showAlert(msg, title, 'info', confirm, callback);
        },
        showAlertError: function (msg, title = 'Error', confirm, callback) {
            this.showAlert(msg, title, 'error', confirm, callback);
        },
        showAlertWarning: function (msg, title = 'Warning', confirm, callback) {
            this.showAlert(msg, title, 'warning', confirm, callback);
        },
        getLoadIndicator: function () {
            return $("#_loading_indicator").clone().html();
        },
        toggleButtonControl: function (flag) {
            if (flag) {
                $('input[type="button"]').attr('disabled', 'disabled');
                $('button').attr('disabled', 'disabled');
                $('a[role="button"]').attr('disabled', 'disabled');
            } else {
                $('input[type="button"]').removeAttr('disabled');
                $('button').removeAttr('disabled');
                $('a[role="button"]').removeAttr('disabled');
            }
        },
        showModal: function (url, params, title, positionTop, maxWidth, modalCustomId, callback) {
            var idx = NextRandom();
            if (modalCustomId == undefined || modalCustomId == null || modalCustomId == '') {
                modalCustomId = 'modal-basic-custom-' + idx;
            }

            if (positionTop == true) {
                $('#modal-basic').find('.modal-dialog').removeClass("modal-dialog-centered");
            }
            else {
                $('#modal-basic').find('.modal-dialog').addClass("modal-dialog-centered");
            }

            if (maxWidth !== undefined && maxWidth !== null && maxWidth !== '') {
                if(maxWidth.toString().endsWith('px') == false) {
                    maxWidth = maxWidth + 'px';
                }
                $('#modal-basic').find('.modal-dialog').css('max-width', maxWidth);
            }
            else {
                $('#modal-basic').find('.modal-dialog').css('max-width', '');
            }

            $('#modal-basic').find('.modal-custom-div').attr('id', modalCustomId);
            $('#modal-basic').find('.modal-title').html(title);
            $('#modal-basic').find('.modal-body').load(url, params, function () {
                $('#modal-basic').off('ok-click').on('ok-click', function (e, d) {
                    if (typeof callback == 'function') {
                        callback(d.items);
                    }
                });
                $('#modal-basic button[data-type=ok]').off('click').on('click', function () { 
                    $('#modal-basic').trigger('ok-click', { items: null });
                });
            });
            $('#modal-basic').modal('show');
        },
        showModalError: function (msg, title, btnType) {
            $('#modal-alert').find('.modal-title').html(title);
            $('#modal-alert').find('.alert-danger').html(msg);
            $('#modal-alert').modal('show');
        },
        showModalMessage: function (msg, title) {
            $('#modal-message').find('.modal-title').html(title);
            $('#modal-message').find('.modal-body').html(msg);
            $('#modal-message').modal('show');
        },
        showModalMessageError: function (msg, title) {
            $('#modal-message-error').find('.modal-title').html(title);
            $('#modal-message-error').find('.alert-danger').html(msg);
            $('#modal-message-error').modal('show');
        },
        showModalSearchGroup: function (treeType, groupTypeId, positionTop, isperm, callback) {
            var idx = NextRandom();
            var modalCustomId = 'modal-basic-custom-' + idx;
            var mWidth = '350px';
            this.showModal('/UICommon/Component/modal/searchgroup', { id: modalCustomId, treetype: treeType, grouptypeid: groupTypeId, isperm: isperm }, '그룹 조회', positionTop, mWidth, modalCustomId, callback);
        },
        showModalSearchUser: function (includeTree, positionTop, isperm, callback) {
            var idx = NextRandom();
            var modalCustomId = 'modal-basic-custom-' + idx;
            var mWidth = includeTree == true ? '1160px' : '920px';
            this.showModal('/UICommon/Component/modal/searchuser', { id: modalCustomId, istree: includeTree, isperm: isperm }, '사용자 조회', positionTop, mWidth, modalCustomId, callback);
        },
        showToastr: function (message, title, type, options) {
            if (options) {
                toastr.options = options;
            }

            if (title == undefined || title == null)
                title = "<i class='fa fa-bell'/> Notification";

            if (type !== undefined && type !== null && type !== '') {
                toastr[type](message, title);
            }
            else {
                toastr["info"](message, title);
            }
        },
        showToastrInfo: function (message, callback, title, options) {
            if (options) {
                options.toastClass = "toast bg-blue";
            }
            else {
                options = {
                    toastClass: "toast bg-blue"
                };
            }

            if (callback)
                options.onHidden = callback;

            this.showToastr(message, title, "info", options);
        },
        showToastrSuccess: function (message, callback, title, options) {
            if (options) {
                options.toastClass = "toast bg-teal";
            }
            else {
                options = {
                    toastClass: "toast bg-teal"
                };
            }

            if (callback)
                options.onHidden = callback;

            this.showToastr(message, title, "success", options);
        },
        showToastrWarning: function (message, callback, title, options) {
            if (options) {
                options.toastClass = "toast bg-yellow";
            }
            else {
                options = {
                    toastClass: "toast bg-yellow"
                };
            }

            if (callback)
                options.onHidden = callback;

            this.showToastr(message, title, "warning", options);
        },
        showToastrError: function (message, callback, title, options) {
            if (options) {
                options.timeOut = 0;
                options.toastClass = "toast bg-red";
                options.closeButton = true;
                options.extendedTimeOut = 0;
                options.tapToDismiss = false;
            }
            else {
                options = {
                    timeOut: 0, //오류 toastr은 자동으로 사라지지 않음
                    closeButton: true, //닫기 버튼 추가
                    toastClass: "toast bg-red",
                    extendedTimeOut: 0,
                    tapToDismiss: false //닫기 버튼 클릭시에만 사라지도록 처리
                };
            }

            if (callback)
                options.onHidden = callback;

            this.showToastr(message, title, "error", options);
        },
        showToastrErrorStickyWide: function (message, title, options) {
            if (!options) {
                options = {
                    timeOut: 0, //오류 toastr은 자동으로 사라지지 않음
                    closeButton: true, //닫기 버튼 추가
                    toastClass: "toast bg-red",
                    positionClass: "toast-top-full-width",
                    extendedTimeOut: 0,
                    tapToDismiss: false //닫기 버튼 클릭시에만 사라지도록 처리
                };
            }

            this.showToastr(message, title, "error", options);
        },
        showOffcanvas: function (flag, placement, title, body, width) {
            if (flag == undefined) {
                flag = true;
            }

            if (placement == undefined || placement == '') {
                placement = 'start';
            }

            if (flag) {
                $('.offcanvas-' + placement).offcanvas('show');
                $('.offcanvas-' + placement).width(width);
                $('.offcanvas-' + placement).children().scrollTop(0);
                $('.offcanvas-' + placement).find('.offcanvas-title').html(title);
                $('.offcanvas-' + placement).find('.offcanvas-body').html(body);
            }
            else {
                $('.offcanvas-' + placement).offcanvas('hide');
            }
        },
        showAjaxError: function (event, jqXHR, ajaxSettings, thrownError) {
            //jquery ajax 는 http status 307을 오류로 인식
            //사전 인증 필터에 의해 인증이 되지 않은 상태에서 ajax call이 호출되는 경우 307 오류와 현재 app의 root url을 전달
            //초기 페이지로 redirect를 발생 시켜 다시 인증 flow 를 거치도록 유도.
            if (jqXHR.status == '307') {
                location.reload();
            }
            else if (jqXHR.responseJSON) {
                var msg = '<div class="row"><div class="col">';
                $.each(jqXHR.responseJSON, function (i, e) {
                    msg += _InitUtil.generateAjaxErrorBody(e, i);
                });
                msg += '</div></div>';

                BaseScriptUtil.showToastrError(msg, null, '', {
                    positionClass: 'toast-top-full-width' //ajax 오류는 넓은 영역에 표시
                });
            }
            else if (jqXHR.responseText) {
                if (jqXHR.responseText.indexOf('<!DOCTYPE') > 0 || jqXHR.responseText.indexOf('<html') > 0) {
                    var newDoc = document.open("text/html", "replace");
                    newDoc.write(jqXHR.responseText);
                    newDoc.close();
                }
                else {
                    var result = JSON.parse(jqXHR.responseText);
                    var msg = '<div class="row"><div class="col">';
                    $.each(result, function (i, e) {
                        msg += _InitUtil.generateAjaxErrorBody(e, i);
                    });
                    msg += '</div></div>';

                    BaseScriptUtil.showToastrError(msg, null, '', {
                        positionClass: 'toast-top-full-width' //ajax 오류는 넓은 영역에 표시
                    });
                }
            }
            else {
                //ajax 호출 시 핸들링 되지 않은 오류. CORS 나 redirection 이 원인일 가능성.
                location.href = '/uicommon/error/RaiseException?errorcode=079003&msg=' + JSON.stringify({ jqXHR: jqXHR, ajaxSettings: ajaxSettings });
            }
        },
        serializeObject: function (item) {
            //JQuery known issue : serializeArray()에서 checkbox type은 반환하지 않음.
            var o = {};
            var a = item.serializeArray();
            $.each(a, function () {
                if (o[this.name]) {
                    if (!o[this.name].push) {
                        o[this.name] = [o[this.name]];
                    }
                    o[this.name].push(this.value || '');
                } else {
                    o[this.name] = this.value || '';
                }
            });
            return o;
        }
    };

    const _InitUtil = {
        generateAjaxErrorBody: function (e, i) {
            var msg = '';
            msg += '<div class="row mt-2' + ((i > 0) ? ' border-top ' : '') + '">';
            msg += '<div class="col">';

            msg += '<div class="row mb-2">';
            msg += '<div class="col-lg-12 h-30px p-5px"><label><h5>' + (i > 0 ? '>'.repeat(i) + ' ' : '') + e.type + '</h5></label></div>'; //inner exception 이 깊어질 경우 구분을 위해 ">" 마크를 추가
            msg += '</div>';

            if (e.errorcode) {
                msg += '<div class="row mb-2">';
                msg += '<div class="col-lg-2"><label class="form-label">Error Code</label></div>';
                msg += '<div class="col-lg-10">' + e.errorcode + '</div>';
                msg += '</div>';
            }

            msg += '<div class="row mb-2">';
            msg += '<div class="col-lg-2"><label class="form-label">Message</label></div>';
            msg += '<div class="col-lg-10" style="white-space:pre-line; word-break:break-all;">' + e.message + '</div>';
            msg += '</div>';

            //m365exception 인 경우 recover 메시지 표시
            if (e.errorcode) {
                msg += '<div class="row mb-2">';
                msg += '<div class="col-lg-2"><label class="form-label">Recommended Action</label></div>';
                msg += '<div class="col-lg-10" style="white-space:pre-line; word-break:break-all;">' + e.recover + '</div>';
                msg += '</div>';
            }

            if (e.stack) {
                msg += '<div class="row mb-2">';
                msg += '<div class="col-lg-2" onClick="_InitUtil.onClickExpandStack(this)"><label class="form-label">Stacktrace</label>&nbsp;<i class="fas fa-plus-square"></i></div>';
                msg += '<div class="col-lg-10" name="stackTrace"><div class="text-ellipsis">' + e.stack + '</div></div>';
                msg += '</div>';
            }

            msg += '</div></div>';
            return msg;
        },
        onClickExpandStack: function (elem) {
            var i = $(elem).children('i');

            if ($(i).hasClass('fa-plus-square')) {
                $(elem).children('i').removeClass('fa-plus-square').addClass('fa-minus-square');
                $(elem).next('div [name="stackTrace"]').children('div').removeClass('text-ellipsis').attr('style', 'white-space:pre-line; word-break:break-all;');
            }
            else {
                $(elem).children('i').removeClass('fa-minus-square').addClass('fa-plus-square');
                $(elem).next('div [name="stackTrace"]').children('div').addClass('text-ellipsis').attr('style', '');
            }
        }
    };

    function NextRandom() {
        return Math.floor(Math.random() * 10000000) + 1;
    }
</script>

         
        <script src="/lib/bootstrap/dist/js/bootstrap.min.js"></script>
    
    </footer>

<!-- Visual Studio Browser Link -->
<script type="text/javascript" src="/_vs/browserLink" async="async" id="__browserLink_initializationData" data-requestId="60b3af27eae442bdbfd6a37aa26cd4cf" data-requestMappingFromServer="false" data-connectUrl="http://localhost:60478/010a06bae2484667b78ac081542d9859/browserLink"></script>
<!-- End Browser Link -->

<script src="/_framework/aspnetcore-browser-refresh.js"></script></body>
</html>
