(function() {
	/*
	 * ---------------------- B. Braun Specific Config ----------------------
	 */
	var DOMAIN = "http://192.168.20.236:8080";
	var CoursesDomain = DOMAIN + "/EvaluationForm/CoursesServlet";
	var loginDomain = DOMAIN + "/EvaluationForm/LoginServlet";
	var FeedbackFormDomain = DOMAIN + "/EvaluationForm/FeedbackFormServlet";
	var FeedbackFormSupervisorDomain = DOMAIN + "/EvaluationForm/FeedbackFormSupervisorServlet";
	var AdminloginDomain = DOMAIN + "/EvaluationForm/AdminLoginServlet";
	var CoursesAddDomain = DOMAIN + "/EvaluationForm/CoursesAddServlet";
	var ReportDomain = DOMAIN + "/EvaluationForm/ReportServlet";
	var ReportSupervisorDomain = DOMAIN + "/EvaluationForm/ReportSupervisorServlet";
	var ReportSummaryDomain = DOMAIN + "/EvaluationForm/ReportSummaryServlet";
	var ReportSupervisorSummaryDomain = DOMAIN + "/EvaluationForm/ReportSupervisorSummaryServlet";
	
//	var DOMAIN = "https://hr.asiapacific.bbraun.com";
//	var scheduleDomain = DOMAIN + "/EvaluationForm_servlet/ScheduleServlet";
//	var loginDomain = DOMAIN + "/EvaluationForm_servlet/LoginServlet";
//	var surveyDomain = DOMAIN + "/EvaluationForm_servlet/SurveyServlet";

	var courseID = localStorage.getItem("courseEvaluationTitleID");
	var course = localStorage.getItem("courseEvaluationTitle")
	var trainer = localStorage.getItem("trainerNameShow");
	var date_time = localStorage.getItem("date_timeCourseShow");
	var venue = localStorage.getItem("venueCourseShow");
	var AdminNO = localStorage.getItem("Admin_no");
	
	/*
	 * ---------------------- Local Variables ------------------------
	 */
	coursesPickView.prototype.template = Handlebars.compile($("#coursesPick").html());
	coursesPositionView.prototype.template = Handlebars.compile($("#coursesPosition").html());
	coursesQuestionPView.prototype.template = Handlebars.compile($("#coursesQuestionP").html());
	coursesQuestionSView.prototype.template = Handlebars.compile($("#coursesQuestionS").html());
	coursesThanksView.prototype.template = Handlebars.compile($("#coursesThanks").html());
	coursesPositionAdminView.prototype.template = Handlebars.compile($("#coursesPositionAdmin").html());
	coursesAddView.prototype.template = Handlebars.compile($("#coursesAdd").html());
	coursesReportView.prototype.template = Handlebars.compile($("#coursesReport").html());
	coursesReportsummaryView.prototype.template = Handlebars.compile($("#coursesReportsummary").html());
	
	// *** coursesPick *** //
	router.addRoute('', function() {
		$('body').html(new coursesPickView().render().$el);
		$('body').scrollTop(0);
//jquery
//		body color
		$('body').css('background-color', '#f2f2f2');

//		get data from database
		$.ajax({
			type : "GET",
			url : CoursesDomain,
			success : function(result) {
				$('#contner-block').append(result);
			}
		});
		
//		hide popup fill all
		$("#popupAlertFillAll").hide();
		
//		filter
	    $(function() {
	        $('#imgbtnfilterYMD').click(function(){
	        	var index = 0;
	        	var filteryear = $('#pickyear :selected').val();
	        	var filtermonth = $('#pickmonth :selected').val(); 
	        	var filterday = $('#pickday :selected').val();
	        	var date = filteryear + '-' + filtermonth +'-'+ filterday;//--->will get 2018-07-02 use to click img to show and hide
	        	
	        	if($('#pickyear :selected').val()=="" || $('#pickmonth :selected').val()=="" || $('#pickday :selected').val()==""){
	        		$("#popupAlertFillAll").show();
					return false;
				}
	        	
	          	$('.bttn-container').hide();
	          	
	          	$(".bttn-container").each(function(index) {
	          		$('#filter'+date+'-'+index).show();
	          	   
	          	});
	        });
	    });

//		close popup button X
		$("#btnCloseAlertFillAll").click(function() {
			var id = $(this).attr("id");
			if (id == "btnCloseAlertFillAll") {
				$("#popupAlertFillAll").hide();
			}
		});
		
//	    Clear filter
		$("#btnCancelFilter").click(function(){
			$(".bttn-container").show();
			$("select#pickyear").val('').attr('selected', true);
			$("select#pickmonth").val('').attr('selected', true);
			$("select#pickday").val('').attr('selected', true);
			});
		
//		get and store value from container 
		$(document.body).on('click', '.bttn-container', function() {
			var OrienCourseID = $(this).find('#OrienCourseID').html();
			localStorage.setItem("courseEvaluationTitleID",$(this).find('#OrienCourseID').html());
			var OrienCourse = $(this).find('#OrienCourse').html();
			localStorage.setItem("courseEvaluationTitle",$(this).find('#OrienCourse').html());
			var OrienTrainer =$(this).find('#OrienTrainer').html();
			localStorage.setItem("trainerNameShow",$(this).find('#OrienTrainer').html());
			var OrienDatetime = $(this).find('#OrienDatetime').html();
			localStorage.setItem("date_timeCourseShow",$(this).find('#OrienDatetime').html());			
			var OrienVenue = $(this).find('#OrienVenue').html();
			localStorage.setItem("venueCourseShow",$(this).find('#OrienVenue').html());

			var url = "#coursesPosition";

			window.location.href = url;
				});	
		
//		hide Admin popup
		$("#AdminpopUp").hide();
		
//		hide popupAlert
		$("#popupAlertAnswersAll").hide();
		$("#popupAlertWrongPassword").hide();
		$("#popUpAlertInsertPassword").hide();

//		resize landscape and portrait
		$(window).resize(function () {
	    var viewportWidth = $(window).width();
	    var viewportHeight = $(window).height();   
		if (viewportHeight > viewportWidth) {
		// Portrait viewportHeight
		// popup 
		$("#popupFillAll").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popupFillAll").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popupFillAll").width() / 2)+'px'
	    });
		$("#popupAnswersAll").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popupAnswersAll").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popupAnswersAll").width() / 2)+'px'
	    });
		$("#popupWrongPassword").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popupWrongPassword").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popupWrongPassword").width() / 2)+'px'
	    });
	    $("#popUpInsertPassword").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popUpInsertPassword").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popUpInsertPassword").width() / 2)+'px'
	    });
		$("#AdminpopLogin").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#AdminpopLogin").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#AdminpopLogin").width() / 2)+'px'
	    });
		}if (viewportHeight < viewportWidth) {
        // Landscape
		//popup 
		$("#popupFillAll").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popupFillAll").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popupFillAll").width() / 2)+'px'
	    });
		$("#popupAnswersAll").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popupAnswersAll").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popupAnswersAll").width() / 2)+'px'
	    });
		$("#popupWrongPassword").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popupWrongPassword").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popupWrongPassword").width() / 2)+'px'
	    });
	    $("#popUpInsertPassword").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popUpInsertPassword").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popUpInsertPassword").width() / 2)+'px'
	    });
		$("#AdminpopLogin").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#AdminpopLogin").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#AdminpopLogin").width() / 2)+'px'
	    });		
		}
	}).resize();	
		
//		Admin login
		$("#linkadminlogin").click(function(){
			$("#AdminpopUp").show();
		});
		
//		Button not login
		$("#btnAdminXLog").click(function() {
			var id = $(this).attr("id");
			if (id == "btnAdminXLog") {
				$("#Admin_no").val("");
				$("#password").val("");
				$("#AdminpopUp").hide();
			}
		});
	
//		close popup button X
		$("#btnAdminClose").click(function() {
			var id = $(this).attr("id");
			if (id == "btnAdminClose") {
				$("#Admin_no").val("");
				$("#password").val("");
				$("#AdminpopUp").hide();
			}
		});
		
//		close popup button X
		$("#btnCloseAlertAnswersAll").click(function() {
			var id = $(this).attr("id");
			if (id == "btnCloseAlertAnswersAll") {
				$("#popupAlertAnswersAll").hide();
			}
		});
		
		$("#btnCloseAlertWrongPassword").click(function() {
			var id = $(this).attr("id");
			if (id == "btnCloseAlertWrongPassword") {
				$("#popupAlertWrongPassword").hide();
			}
		});
		
		$("#btnCloseAlertInsertPassword").click(function() {
			var id = $(this).attr("id");
			if (id == "btnCloseAlertInsertPassword") {
				$("#popUpAlertInsertPassword").hide();
			}
		});

//		check for login
	    $('#btnAdminLogin').click(function()
	    	    {  
					{
	    	       var Admin_no=$('#Admin_no').val();
	    	       var password=$('#password').val();
	    	       if(Admin_no=="" || password==""){
	    	    	   $("#popUpAlertInsertPassword").show();
	    	    	   return false;
	    	       }
	    	       $.ajax({
	    	            type: "POST",
	    	            url: AdminloginDomain,
	    	            data:{"Admin_no":Admin_no,"Admin_pass":password},
	    	            success: function (data) {
	    	            	
	    	                   if(data){
	    	                	   $("#popupAlertWrongPassword").show();
	    	             					      }else{
	    	             					    	 localStorage.setItem("Admin_no",Admin_no);	   
	    	             					    	  window.location.href = "#coursesPositionAdmin";
	    					                   }
	    					            }
	    	                   });
					}
	    	        });

//	    key in number only
		$('#Admin_no').bind('keyup paste', function(){
			var thisnumber = $(this);
			var valuenumber = thisnumber.val();
			var notNumber=new RegExp("[^0-9]","g");
			this.value = this.value.replace(/[^0-9]/g, '');
			if(valuenumber.match(notNumber)){
			$("#errmsg").html("Number Only").show().fadeOut(5000);
			}
		});
		
	});	
	
	// *** coursesPosition *** //
	router.addRoute('coursesPosition', function() {//X
		$('body').html(new coursesPositionView().render().$el);
		$('body').scrollTop(0);
//Jquery		
//		body color
		$('body').css('background-color', 'white');
		
//		navigate to questions page
		$("#btnParticipant").click(function(){
			navTo("#coursesQuestionP");
		});
		
//		navigate to questions page
		$("#btnSupervisor").click(function(){
			navTo("#coursesQuestionS");
		});
		
//		navigate to Selection page
		$("#backtocoursespickpage").click(function(){
			navTo("#");
		});

//		navigate to Selection page
		$("#btnXposition").click(function(){
			navTo("#");
		});
	});

	// *** coursesPositionAdmin *** //
	router.addRoute('coursesPositionAdmin', function() {//X
		$('body').html(new coursesPositionAdminView().render().$el);
		$('body').scrollTop(0);
//Jquery		
//		body color
		$('body').css('background-color', 'white');
		
//		navigate to questions page
		$("#btnCreate").click(function(){
			navTo("#coursesAdd");
		});
		
//		navigate to questions page
		$("#btnReport").click(function(){
			navTo("#coursesReport");
		});
		
//		navigate to Selection page
		$("#btnXAdminposition").click(function(){
			localStorage.removeItem("AdminNO");
			navTo("#");
		});
		
//		navigate to Selection page
		$("#btnReportsummary").click(function(){
			navTo("#coursesReportsummary");
		});

	});
	
	// *** coursesAdd *** //
	router.addRoute('coursesAdd', function() {//X
		$('body').html(new coursesAddView().render().$el);
		$('body').scrollTop(0);
//Jquery		
//		body color
		$('body').css('background-color', 'white');

//		hide popup fill all
		$("#popupAlertFillAll").hide();
		
//		get Admin id from storage into text box
		$("#AddEmployee_no").val(localStorage.getItem("Admin_no"));
		
//		close popup button X
		$("#btnCloseAlertFillAll").click(function() {
			var id = $(this).attr("id");
			if (id == "btnCloseAlertFillAll") {
				$("#popupAlertFillAll").hide();
			}
		});
		
//		get date by selection box
	    $('#btnSubmitcreate').click(function(){
	        	var coursesAddYear = $('#coursesAddYear :selected').val();
	        	var coursesAddMonth = $('#coursesAddMonth :selected').val(); 
	        	var coursesAddDay = $('#coursesAddDay :selected').val();
	        	var AddDate = coursesAddYear + coursesAddMonth + coursesAddDay;//--->will get 2018-07-02 

	        	var coursesAddStartHours = $('#coursesAddStartHours :selected').val();
	        	var coursesAddStartMinutes = $('#coursesAddStartMinutes :selected').val(); 
	        	var AddStartTime = coursesAddStartHours + coursesAddStartMinutes;//--->will get 01:15

	        	var coursesAddEndHours = $('#coursesAddEndHours :selected').val();
	        	var coursesAddEndMinutes = $('#coursesAddEndMinutes :selected').val(); 
	        	var AddEndTime = coursesAddEndHours + coursesAddEndMinutes;
	
	        	$("#CreateCoursesDate").val(AddDate);
	        	$("#CreateCoursesStartTime").val(AddStartTime);
	        	$("#CreateCoursesEndTime").val(AddEndTime);

	        });
		
//		resize landscape and portrait
		$(window).resize(function () {
	    var viewportWidth = $(window).width();
	    var viewportHeight = $(window).height();   
		if (viewportHeight > viewportWidth) {
		// Portrait viewportHeight
		// popup 
		$("#popupFillAll").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popupFillAll").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popupFillAll").width() / 2)+'px'
	    });
		}if (viewportHeight < viewportWidth) {
        // Landscape
		//popup 
		$("#popupFillAll").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popupFillAll").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popupFillAll").width() / 2)+'px'
	    });
		}
	}).resize();	
		
//		navigate to questions page and clean admin id in text box
		$("#btnCancelcreate").click(function(){
			navTo("#coursesPositionAdmin");
		});
		
//		check alert if null
		$("#btnSubmitcreate").click(function(){
			if($('#coursesAddStartHours :selected').val()=="" || $('#coursesAddStartMinutes :selected').val()==""){
				$("#popupAlertFillAll").show();
				return false;
			}
			if($('#coursesAddEndHours :selected').val()=="" || $('#coursesAddEndMinutes :selected').val()==""){
				$("#popupAlertFillAll").show();;
				return false;
			}
			if($('#coursesAddYear :selected').val()=="" || $('#coursesAddMonth :selected').val()=="" || $('#coursesAddDay :selected').val()==""){
				$("#popupAlertFillAll").show();
				return false;
			}
			if($('#AddEmployee_no').val() =="" ||  $('#CreateCoursesTitle').val()=="" || $('#CreateCoursesVenue').val() =="" || $('#CreateCoursesTrainer').val() ==""){
				$("#popupAlertFillAll").show();
				return false;
			}
//				post data
				if (checkTextInput("#AddEmployee_no")
						&& checkTextInput("#CreateCoursesTitle")
						&& checkTextInput("#CreateCoursesVenue")
						&& checkTextInput("#CreateCoursesStartTime")
						&& checkTextInput("#CreateCoursesEndTime")
						&& checkTextInput("#CreateCoursesDate")
						&& checkTextInput("#CreateCoursesTrainer")
						) {
				$.post(CoursesAddDomain,
						{
					
					AddEmployee_no : $('#AddEmployee_no').val(),
					CreateCoursesTitle : $('#CreateCoursesTitle').val(),
					CreateCoursesVenue : $('#CreateCoursesVenue').val(),
					CreateCoursesStartTime : $('#CreateCoursesStartTime').val(),
					CreateCoursesEndTime: $('#CreateCoursesEndTime').val(),
					CreateCoursesDate: $('#CreateCoursesDate').val(),
					CreateCoursesTrainer: $('#CreateCoursesTrainer').val()
						})
						.done(function() {
							localStorage.removeItem("AdminNO");
							$('#AddEmployee_no').val('');
							window.location.href = "#coursesPositionAdmin";

						})
						.fail(function(ex) {
							alert("error");
							alert(ex);
						});
				}
		});
//		https://www.aspsnippets.com/Articles/ASPNet-jQuery-AJAX-CRUD-Select-Insert-Edit-Update-and-Delete-in-ASPNet-GridView-using-jQuery-AJAX.aspx
		//function to check textbox
		function checkTextInput(answers) {
			if ($(answers).val().trim().length > 0) {
				
				return true;
			} else {
				return false;
			}
		}

	});
	
	// *** coursesReport *** //
	router.addRoute('coursesReport', function() {
		$('body').html(new coursesReportView().render().$el);
		$('body').scrollTop(0);
//Jquery		
//		body color
		$('body').css('background-color', 'white');
		
//		get data for report from database
		$.ajax({
			type : "GET",
			url : ReportDomain,
			success : function(result) {
				$('#reporttable').append(result);
			}
		});
		
//		get data for report supervisor from database
		$.ajax({
			type : "GET",
			url : ReportSupervisorDomain,
			success : function(result) {
				$('#reportsupervisortable').append(result);
			}
		});
		
//		navigate to Admin position page
		$("#btnXReport").click(function(){
			navTo("#coursesPositionAdmin");
		});
		
	    //Delete event handler.
//	    $("body").on("click", "[id*=gvCustomers] .Delete", function () {
//	        if (confirm("Do you want to delete this row?")) {
//	            var row = $(this).closest("tr");
//	            var customerId = row.find("span").html();
//	            $.ajax({
//	                type: "POST",
//	                url: "Default.aspx/DeleteCustomer",
//	                data: '{customerId: ' + customerId + '}',
//	                contentType: "application/json; charset=utf-8",
//	                dataType: "json",
//	                success: function (response) {
//	                    row.remove();
//	                }
//	            });
//	        }
//	 
//	        return false;
//	    });
//	    
//		$("#reporttable").on('click', '.btnDelete', function () {
//		    $(this).closest('tr').remove();
//		});
		
//		export https://codepattern.net/Blog/post/jQuery-export-table-data-into-MS-Excel
//
		$("#btnExport").click(function(e) {
	    window.open('data:application/vnd.ms-excel,' + encodeURIComponent( $('div[id$=ResultParticipant]').html()));
	    e.preventDefault();
		});


//			    // This must be a hyperlink
//			    $("#btnExport").on('click', function (event) {
//			        // CSV
//			        var args = [$('#ResultParticipant'), 'export.csv'];
//			        
//			        exportTableToCSV.apply(this, args);
//			        
//			        // If CSV, don't do event.preventDefault() or return false
//			        // We actually need this to be a typical hyperlink
//			    });

		
		$( "#btnExportSupervisor" ).click(function() {  
		    window.open('data:application/vnd.ms-excel,' + encodeURIComponent( $('div[id$=ResultSupervisor]').html()));
		    e.preventDefault();
//			  var ResultSupervisor = $('#ResultSupervisor').html();     
//			  window.open('data:application/vnd.ms-excel,' + $('#ResultSupervisor').html());
			});
//		http://www.jquerybyexample.net/2012/10/export-table-data-to-excel-using-jquery.html

		
		
//	    function exportTableToCSV($table, filename) {
//
//	        var $rows = $table.find('tr:has(td)'),
//
//	            // Temporary delimiter characters unlikely to be typed by keyboard
//	            // This is to avoid accidentally splitting the actual contents
//	            tmpColDelim = String.fromCharCode(11), // vertical tab character
//	            tmpRowDelim = String.fromCharCode(0), // null character
//
//	            // actual delimiter characters for CSV format
//	            colDelim = '","',
//	            rowDelim = '"\r\n"',
//
//	            // Grab text from table into CSV formatted string
//	            csv = '"' + $rows.map(function (i, row) {
//	                var $row = $(row),
//	                    $cols = $row.find('td');
//
//	                return $cols.map(function (j, col) {
//	                    var $col = $(col),
//	                        text = $col.text();
//
//	                    return text.replace(/"/g, '""'); // escape double quotes
//
//	                }).get().join(tmpColDelim);
//
//	            }).get().join(tmpRowDelim)
//	                .split(tmpRowDelim).join(rowDelim)
//	                .split(tmpColDelim).join(colDelim) + '"';
//
//					// Deliberate 'false', see comment below
//	        if (false && window.navigator.msSaveBlob) {
//
//							var blob = new Blob([decodeURIComponent(csv)], {
//		              type: 'text/csv;charset=utf8'
//	            });
//	            
//	            // Crashes in IE 10, IE 11 and Microsoft Edge
//	            // See MS Edge Issue #10396033: https://goo.gl/AEiSjJ
//	            // Hence, the deliberate 'false'
//	            // This is here just for completeness
//	            // Remove the 'false' at your own risk
//	            window.navigator.msSaveBlob(blob, filename);
//	            
//	        } else if (window.Blob && window.URL) {
//							// HTML5 Blob        
//	            var blob = new Blob([csv], { type: 'text/csv;charset=utf8' });
//	            var csvUrl = URL.createObjectURL(blob);
//
//	            $(this)
//	            		.attr({
//	                		'download': filename,
//	                		'href': csvUrl
//			            });
//					} else {
//	            // Data URI
//	            var csvData = 'data:application/csv;charset=utf-8,' + encodeURIComponent(csv);
//
//							$(this)
//	                .attr({
//	               		  'download': filename,
//	                    'href': csvData,
//	                    'target': '_blank'
//	            		});
//	        }
//	    }
		
	});

	// *** coursesReportsummary *** //
	router.addRoute('coursesReportsummary', function() {
		$('body').html(new coursesReportsummaryView().render().$el);
		$('body').scrollTop(0);
//Jquery		
//		body color
		$('body').css('background-color', 'white');
		
//		get data for report from database
		$.ajax({
			type : "GET",
			url : ReportSummaryDomain,
			success : function(result) {
				$('#ResultParticipantsummary').append(result);
			}
		});
		
//		get data for report from database
		$.ajax({
			type : "GET",
			url : ReportSupervisorSummaryDomain,
			success : function(result) {
				$('#ResultSupervisorsummary').append(result);
			}
		});
		

		
//		navigate to Admin position page
		$("#btnXReportsummary").click(function(){
			navTo("#coursesPositionAdmin");
		});

//		export https://codepattern.net/Blog/post/jQuery-export-table-data-into-MS-Excel
//
		$("#btnExportsummary").click(function(e) {
	    window.open('data:application/vnd.ms-excel,' + encodeURIComponent( $('div[id$=ResultParticipantsummary]').html()));
	    e.preventDefault();
		});
		
//		export https://codepattern.net/Blog/post/jQuery-export-table-data-into-MS-Excel
//
		$("#btnExportSupervisorsummary").click(function(e) {
	    window.open('data:application/vnd.ms-excel,' + encodeURIComponent( $('div[id$=ResultSupervisorsummary]').html()));
	    e.preventDefault();
		});

//		http://www.jquerybyexample.net/2012/10/export-table-data-to-excel-using-jquery.html
		
	});

	// *** coursesQuestionP *** //
	router.addRoute('coursesQuestionP', function() {
		$('body').html(new coursesQuestionPView().render().$el);
		$('body').scrollTop(0);
//jquery	
//		body color
		$('body').css('background-color', '#f2f2f2');
		
//		get containt from selection page	    
		$("#courseEvaluationTitle").html("<strong class=\"txtblack\">Course: </strong><br><ol><li style=\"list-style-type: none\">" + localStorage.getItem("courseEvaluationTitle")+"</li></ol>");
        $("#trainerNameShow").html("<strong class=\"txtblack\">Trainer: </strong><br><ol><li style=\"list-style-type: none\">" + localStorage.getItem("trainerNameShow")+"</li></ol>");
        $("#date_timeCourseShow").html("<strong class=\"txtblack\">Date & Time: </strong><br><ol><li style=\"list-style-type: none\">" + localStorage.getItem("date_timeCourseShow")+"</li></ol>");
        $("#venueCourseShow").html("<strong class=\"txtblack\">Venue: </strong><br><ol><li style=\"list-style-type: none\">" + localStorage.getItem("venueCourseShow")+"</li></ol>");

//		get containt from selection page for database
		$("#courseEvaluationTitledb").val(localStorage.getItem("courseEvaluationTitle"));
		$("#courseEvaluationTitleIDdb").val(localStorage.getItem("courseEvaluationTitleID"));
		    		
//		hide popup
		$("#popUp").hide();
		
//		hide popupAlert
		$("#popupAlertAnswersAll").hide();
		$("#popupAlertWrongPassword").hide();
		$("#popUpAlertInsertPassword").hide();
		
//		hide all radiobutton, textbox, checkbox
		$("#P_q1_2_if_yes").hide();
		$("#P_q1_2_if_yes1").hide();
		$("#P_Pick_Q1_2_5_comment").hide();
		$("#P_Pick_Q1_2_no").hide();
		$("#P_Pick_Q1_2_no_comment").hide();
		$("#P_Pick_Q2_comment").hide();

//		hide and show radiobutton, textbox, checkbox when click 
		$("#P_Pick_Q1_8,#P_Pick_Q1_9,#P_Pick_Q1_10").click(function() {
			var id = $(this).attr("id");
			if (id == "P_Pick_Q1_8" || id == "P_Pick_Q1_9" || id == "P_Pick_Q1_10") {
				$("#P_q1_2_if_yes").show();
				$("#P_q1_2_if_yes1").show();
				$("#P_Pick_Q1_2_no").hide();
				$("#P_Pick_Q1_2_no_comment").hide();
				$("#P_Pick_Q1_2_no_comment").val("");
			}
		});
		
		$("#P_Pick_Q1_1,#P_Pick_Q1_2,#P_Pick_Q1_3,#P_Pick_Q1_4,#P_Pick_Q1_5,#P_Pick_Q1_6,#P_Pick_Q1_7").click(function() {
			var id = $(this).attr("id");
			if (id == "P_Pick_Q1_1" || id == "P_Pick_Q1_2" || id == "P_Pick_Q1_3" || id == "P_Pick_Q1_4" || id == "P_Pick_Q1_5" || id == "P_Pick_Q1_6" || id == "P_Pick_Q1_7") {
				$("#P_q1_2_if_yes").show();
				$("#P_Pick_Q1_2_no_comment").show();
				$("#P_Pick_Q1_2_no").show();
				$("#P_q1_2_if_yes1").hide().find('#P_Pick_Q1_2_5_comment').hide().val("");
			}
		});

		$("#P_Pick_Q1_2_5").click(function() {
			var id = $(this).attr("id");
			if (id == "P_Pick_Q1_2_5") {
				$("#P_Pick_Q1_2_5_comment").toggle();
				$("#P_Pick_Q1_2_5_comment").val("");
			}
		});

		$("#P_Pick_Q2_5").click(function() {
			var id = $(this).attr("id");
			if (id == "P_Pick_Q2_5") {
				$("#P_Pick_Q2_comment").toggle();
				$("#P_Pick_Q2_comment").val("");
			}
		});

		
//		resize landscape and portrait
		$(window).resize(function () {
	    var viewportWidth = $(window).width();
	    var viewportHeight = $(window).height();   
		if (viewportHeight > viewportWidth) {
		// Portrait viewportHeight
		// popup 
		$("#popupAnswersAll").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popupAnswersAll").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popupAnswersAll").width() / 2)+'px'
	    });
		$("#popupWrongPassword").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popupWrongPassword").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popupWrongPassword").width() / 2)+'px'
	    });
	    $("#popUpInsertPassword").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popUpInsertPassword").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popUpInsertPassword").width() / 2)+'px'
	    });
		$("#popLogin").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popLogin").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popLogin").width() / 2)+'px'
	    });
		}if (viewportHeight < viewportWidth) {
        // Landscape
		//popup 
		$("#popupAnswersAll").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popupAnswersAll").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popupAnswersAll").width() / 2)+'px'
	    });
		$("#popupWrongPassword").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popupWrongPassword").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popupWrongPassword").width() / 2)+'px'
	    });
	    $("#popUpInsertPassword").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popUpInsertPassword").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popUpInsertPassword").width() / 2)+'px'
	    });
		$("#popLogin").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popLogin").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popLogin").width() / 2)+'px'
	    });	
		}
	}).resize();

//		navigate to positions page
		$("#backtoPcoursespositionpage").click(function(){
			navTo("#coursesPosition");
		});

//		event to show and hide popup
		$("#P_btnSubmitdata").click(function() {  
			if($('input[id="P_Pick_Q1_2_5"]:checked').val() =="5" &&  $('#P_Pick_Q1_2_5_comment').val()==""){
				$("#popupAlertAnswersAll").show();
				return false;
			}
			if($('input[id="P_Pick_Q2_5"]:checked').val() =="5" &&  $('#P_Pick_Q2_comment').val()==""){
				$("#popupAlertAnswersAll").show();
				return false;
			}
			if(($('input[name="P_Pick_Q1"]:checked').val() =="1" || $('input[name="P_Pick_Q1"]:checked').val() =="2" || $('input[name="P_Pick_Q1"]:checked').val() =="3" || $('input[name="P_Pick_Q1"]:checked').val() =="4" || $('input[name="P_Pick_Q1"]:checked').val() =="5" || $('input[name="P_Pick_Q1"]:checked').val() =="6" || $('input[name="P_Pick_Q1"]:checked').val() =="7") &&  $('#P_Pick_Q1_2_no_comment').val()==""){
				$("#popupAlertAnswersAll").show();
				return false;
			}
			if(($('input[name="P_Pick_Q1"]:checked').val() =="8" || $('input[name="P_Pick_Q1"]:checked').val() =="9" || $('input[name="P_Pick_Q1"]:checked').val() =="10")
					&& (checkCheckboxInput("P_Pick_Q1_2_1")==""
					&& checkCheckboxInput("P_Pick_Q1_2_2")==""
					&& checkCheckboxInput("P_Pick_Q1_2_3")==""
					&& checkCheckboxInput("P_Pick_Q1_2_4")==""
					&& checkCheckboxInput("P_Pick_Q1_2_5")=="")){
				$("#popupAlertAnswersAll").show();
				return false;
			}
			if(checkRadioInput("P_Pick_Q1")==""
				|| (checkCheckboxInput("P_Pick_Q2_1")==""
				&& checkCheckboxInput("P_Pick_Q2_2")==""
				&& checkCheckboxInput("P_Pick_Q2_3")==""
				&& checkCheckboxInput("P_Pick_Q2_4")==""
				&& checkCheckboxInput("P_Pick_Q2_5")=="")
				|| checkRadioInput("P_Pick_Q3_months")==""
				|| checkTextInput("#courseEvaluationTitledb")==""
				|| checkTextInput("#courseEvaluationTitleIDdb")==""
				){

				$("#popupAlertAnswersAll").show();
			
				return false;
			}
	    	 else{
			var id = $(this).attr("id");
			if (id == "P_btnSubmitdata") {
				$("#popUp").show();
			}
			}
		});

//		Button not login
		$("#btnXLog").click(function() {
			var id = $(this).attr("id");
			if (id == "btnXLog") {
				$("#Employee_no").val("");
				$("#password").val("");
				$("#popUp").hide();
			}
		});
	
//		close popup button X
		$("#btnClose").click(function() {
			var id = $(this).attr("id");
			if (id == "btnClose") {
				$("#Employee_no").val("");
				$("#password").val("");
				$("#popUp").hide();
			}
		});
		
//		close popup button X
		$("#btnCloseAlertAnswersAll").click(function() {
			var id = $(this).attr("id");
			if (id == "btnCloseAlertAnswersAll") {
				$("#popupAlertAnswersAll").hide();
			}
		});
		
		$("#btnCloseAlertWrongPassword").click(function() {
			var id = $(this).attr("id");
			if (id == "btnCloseAlertWrongPassword") {
				$("#popupAlertWrongPassword").hide();
			}
		});
		
		$("#btnCloseAlertInsertPassword").click(function() {
			var id = $(this).attr("id");
			if (id == "btnCloseAlertInsertPassword") {
				$("#popUpAlertInsertPassword").hide();
			}
		});
					
//		check for login
	    $('#btnLogin').click(function()
	    	    {  
					{
	    	       var Employee_no=$('#Employee_no').val();
	    	       var password=$('#password').val();
	    	       if(Employee_no=="" || password==""){
	    	    	   $("#popUpAlertInsertPassword").show();
	    	    	   return false;
	    	       }
	    	       $.ajax({
	    	            type: "POST",
	    	            url: loginDomain,
	    	            data:{"Emp_no":Employee_no,"Emp_pass":password},
	    	            success: function (data) {
	    	            	
	    	                   if(data){
	    	                	   $("#popupAlertWrongPassword").show();
	    	             					      }else{
//	    	         					              alert('Welcome....');
//	    	        	    	                	check and post feedback
	    	             					    	 if($('input[id=P_Pick_Q1_2_1]').is(':checked')){
	    	             								$('#P_Pick_Q1_2_1').prop('checked', true).val(1);
	    	             							}else{
	    	             								$('#P_Pick_Q1_2_1').prop('checked', true).val(0);
	    	             							}
	    	             							if($('input[id=P_Pick_Q1_2_2]').is(':checked')){
	    	             								$('#P_Pick_Q1_2_2').prop('checked', true).val(2);
	    	             							}else{
	    	             								$('#P_Pick_Q1_2_2').prop('checked', true).val(0);
	    	             							}
	    	             							if($('input[id=P_Pick_Q1_2_3]').is(':checked')){
	    	             								$('#P_Pick_Q1_2_3').prop('checked', true).val(3);
	    	             							}else{
	    	             								$('#P_Pick_Q1_2_3').prop('checked', true).val(0);
	    	             							}
	    	             							if($('input[id=P_Pick_Q1_2_4]').is(':checked')){
	    	             								$('#P_Pick_Q1_2_4').prop('checked', true).val(4);
	    	             							}else{
	    	             								$('#P_Pick_Q1_2_4').prop('checked', true).val(0);
	    	             							}
	    	             							if($('input[id=P_Pick_Q1_2_5]').is(':checked')){
	    	             								$('#P_Pick_Q1_2_5').prop('checked', true).val(5);
	    	             							}else{
	    	             								$('#P_Pick_Q1_2_5').prop('checked', true).val(0);
	    	             							}
	    	             							
	    	             							if($('input[id=P_Pick_Q2_1]').is(':checked')){
	    	             								$('#P_Pick_Q2_1').attr('checked', true).val(1);
	    	             							}else{
	    	             								$('#P_Pick_Q2_1').attr('checked', true).val(0);
	    	             							}
	    	             							if($('input[id=P_Pick_Q2_2]').is(':checked')){
	    	             								$('#P_Pick_Q2_2').attr('checked', true).val(2);
	    	             							}else{
	    	             								$('#P_Pick_Q2_2').attr('checked', true).val(0);
	    	             							}
	    	             							if($('input[id=P_Pick_Q2_3]').is(':checked')){
	    	             								$('#P_Pick_Q2_3').attr('checked', true).val(3);
	    	             							}else{
	    	             								$('#P_Pick_Q2_3').attr('checked', true).val(0);
	    	             							}
	    	             							if($('input[id=P_Pick_Q2_4]').is(':checked')){
	    	             								$('#P_Pick_Q2_4').attr('checked', true).val(4);
	    	             							}else{
	    	             								$('#P_Pick_Q2_4').attr('checked', true).val(0);
	    	             							}
	    	             							if($('input[id=P_Pick_Q2_5]').is(':checked')){
	    	             								$('#P_Pick_Q2_5').attr('checked', true).val(5);
	    	             							}else{
	    	             								$('#P_Pick_Q2_5').attr('checked', true).val(0);
	    	             							}

	    	      									if (checkRadioInput("P_Pick_Q1")
	    	      											|| checkCheckboxInput("P_Pick_Q1_2_1")
	    	      											|| checkCheckboxInput("P_Pick_Q1_2_2")
	    	      											|| checkCheckboxInput("P_Pick_Q1_2_3")
	    	      											|| checkCheckboxInput("P_Pick_Q1_2_4")
	    	      											|| checkCheckboxInput("P_Pick_Q1_2_5")
	    	      											|| checkCheckboxInput("P_Pick_Q2_1")
	    	      											|| checkCheckboxInput("P_Pick_Q2_2")
	    	      											|| checkCheckboxInput("P_Pick_Q2_3")
	    	      											|| checkCheckboxInput("P_Pick_Q2_4")
	    	      											|| checkCheckboxInput("P_Pick_Q2_5")
	    	      											|| checkRadioInput("P_Pick_Q3_months")
	    	      											|| checkTextInput("#P_Pick_Q1_2_5_comment")
	    	      											|| checkTextInput("#P_Pick_Q1_2_no_comment")
	    	      											|| checkTextInput("#P_Pick_Q2_comment")
	    	      										&& checkTextInput("#courseEvaluationTitledb")
	    	      										&& checkTextInput("#courseEvaluationTitleIDdb")
	    	      										&& checkTextInput("#Employee_no")
															) {
//	    	      										post data checked

	    	      										$.post(FeedbackFormDomain,
	    	      												{
	    	      									    	
	    	      	  										Q1 : $('input[name="P_Pick_Q1"]:checked').val(),
	    	      	  										Q1_1 : $('input[id="P_Pick_Q1_2_1"]:checked').val(),
	    	      	  										Q1_2 : $('input[id="P_Pick_Q1_2_2"]:checked').val(),
	    	      	  										Q1_3 : $('input[id="P_Pick_Q1_2_3"]:checked').val(),
	    	      	  										Q1_4 : $('input[id="P_Pick_Q1_2_4"]:checked').val(),
	    	      	  										Q1_5 : $('input[id="P_Pick_Q1_2_5"]:checked').val(),
	    	      	  										Q2_1 : $('input[id="P_Pick_Q2_1"]:checked').val(),
	    	      	  										Q2_2 : $('input[id="P_Pick_Q2_2"]:checked').val(),
	    	      	  										Q2_3 : $('input[id="P_Pick_Q2_3"]:checked').val(),
	    	      	  										Q2_4 : $('input[id="P_Pick_Q2_4"]:checked').val(),
	    	      	  										Q2_5 : $('input[id="P_Pick_Q2_5"]:checked').val(),
	    	      	  										Q3 : $('input[name="P_Pick_Q3_months"]:checked').val(),
	    	      	  										Q1_5_C_g : $('#P_Pick_Q1_2_5_comment').val(),
	    	      	  										Q1_5_C_b : $('#P_Pick_Q1_2_no_comment').val(),
	    	      	  										Q2_5_C : $('#P_Pick_Q2_comment').val(),
	    	      											courseTitle: $('#courseEvaluationTitledb').val(),
	    	      											Course_id: $('#courseEvaluationTitleIDdb').val(),
	    	      											Emp_no_create: $('#Employee_no').val()  								
	    	      	  										})
	    	      												.done(function() {
	    	      													window.location.href = "#coursesThanks";

	    	       												})
	    	       												.fail(function(ex) {
	    	       													alert(ex);
	    	      												});

	    	      												}


	    					                   }
	    					            }
	    	                   });
					}
	    	        });

//	    key in number only
		$('#Employee_no').bind('keyup paste', function(){
			var thisnumber = $(this);
			var valuenumber = thisnumber.val();
			var notNumber=new RegExp("[^0-9]","g");
			this.value = this.value.replace(/[^0-9]/g, '');
			if(valuenumber.match(notNumber)){
			$("#errmsg").html("Number Only").show().fadeOut(5000);
			}
		});
	  
//		navigate back to selection page and remove current values store
		$("#P_btnCanceldata").click(function(){
			localStorage.removeItem("course");
			localStorage.removeItem("trainer");
			localStorage.removeItem("date_time");
			localStorage.removeItem("venue");
			$('#courseEvaluationTitledb').val('');
			$('#courseEvaluationTitleIDdb').val('');
			navTo("#coursesPosition");
		});
		
		//function to check checkbox
		function checkCheckboxInput(answer) {
			if ($('input[id="' + answer + '"]:checked').length > 0) {
				
				return true;
			} else {
				return false;
			}
		}
		
	//function to check radio button
	function checkRadioInput(answer) {
		if ($('input[name="' + answer + '"]:checked').length > 0) {
			
			return true;
		} else {
			return false;
		}
	}
	
	//function to check textarea
	function checkTextInput(answers) {
		if ($(answers).val().trim().length > 0) {
			
			return true;
		} else {
			return false;
		}
	}
		
	});
	
	// *** coursesQuestionS *** //
	router.addRoute('coursesQuestionS', function() {//X
		$('body').html(new coursesQuestionSView().render().$el);
		$('body').scrollTop(0);
		//jquery	
//		body color
		$('body').css('background-color', '#f2f2f2');
		
//		get containt from selection page	    
		$("#courseEvaluationTitle").html("<strong class=\"txtblack\">Course: </strong><br><ol><li style=\"list-style-type: none\">" + localStorage.getItem("courseEvaluationTitle")+"</li></ol>");
        $("#trainerNameShow").html("<strong class=\"txtblack\">Trainer: </strong><br><ol><li style=\"list-style-type: none\">" + localStorage.getItem("trainerNameShow")+"</li></ol>");
        $("#date_timeCourseShow").html("<strong class=\"txtblack\">Date & Time: </strong><br><ol><li style=\"list-style-type: none\">" + localStorage.getItem("date_timeCourseShow")+"</li></ol>");
        $("#venueCourseShow").html("<strong class=\"txtblack\">Venue: </strong><br><ol><li style=\"list-style-type: none\">" + localStorage.getItem("venueCourseShow")+"</li></ol>");

//		get containt from selection page for database
		$("#courseEvaluationTitledb").val(localStorage.getItem("courseEvaluationTitle"));
		$("#courseEvaluationTitleIDdb").val(localStorage.getItem("courseEvaluationTitleID"));
		    		
//		hide popup
		$("#popUp").hide();
		
//		hide popupAlert
		$("#popupAlertAnswersAll").hide();
		$("#popupAlertWrongPassword").hide();
		$("#popUpAlertInsertPassword").hide();
		
//		hide all radiobutton, textbox, checkbox
		$("#S_q1_2_if_yes").hide();
		$("#S_q1_2_if_yes1").hide();
		$("#S_Pick_Q1_2_5_comment").hide();
		$("#S_Pick_Q1_2_no").hide();
		$("#S_Pick_Q1_2_no_comment").hide();
		$("#S_Pick_Q2_comment").hide();

//		hide and show radiobutton, textbox, checkbox when click 
		$("#S_Pick_Q1_8,#S_Pick_Q1_9,#S_Pick_Q1_10").click(function() {
			var id = $(this).attr("id");
			if (id == "S_Pick_Q1_8" || id == "S_Pick_Q1_9" || id == "S_Pick_Q1_10") {
				$("#S_q1_2_if_yes").show();
				$("#S_q1_2_if_yes1").show();
				$("#S_Pick_Q1_2_no").hide();
				$("#S_Pick_Q1_2_no_comment").hide();
				$("#S_Pick_Q1_2_no_comment").val("");
			}
		});
		
		$("#S_Pick_Q1_1,#S_Pick_Q1_2,#S_Pick_Q1_3,#S_Pick_Q1_4,#S_Pick_Q1_5,#S_Pick_Q1_6,#S_Pick_Q1_7").click(function() {
			var id = $(this).attr("id");
			if (id == "S_Pick_Q1_1" || id == "S_Pick_Q1_2" || id == "S_Pick_Q1_3" || id == "S_Pick_Q1_4" || id == "S_Pick_Q1_5" || id == "S_Pick_Q1_6" || id == "S_Pick_Q1_7") {
				$("#S_q1_2_if_yes").show();
				$("#S_Pick_Q1_2_no_comment").show();
				$("#S_Pick_Q1_2_no").show();
				$("#S_q1_2_if_yes1").hide();
				$('#S_Pick_Q1_2_2').prop('checked',false).val(0);
				$('#S_Pick_Q1_2_3').prop('checked',false).val(0);
				$('#S_Pick_Q1_2_4').prop('checked',false).val(0);
				$('#S_Pick_Q1_2_5').prop('checked',false).val(0);
				$('#S_Pick_Q1_2_1').prop('checked',false).val(0);
				$("#S_q1_2_if_yes1").hide().find('#S_Pick_Q1_2_5_comment').hide().val("");
			}
		});

		$("#S_Pick_Q1_2_5").click(function() {
			var id = $(this).attr("id");
			if (id == "S_Pick_Q1_2_5") {
				$("#S_Pick_Q1_2_5_comment").toggle();
				$("#S_Pick_Q1_2_5_comment").val("");
			}
		});

		$("#S_Pick_Q2_5").click(function() {
			var id = $(this).attr("id");
			if (id == "S_Pick_Q2_5") {
				$("#S_Pick_Q2_comment").toggle();
				$("#S_Pick_Q2_comment").val("");
			}
		});

		
//		resize landscape and portrait
		$(window).resize(function () {
	    var viewportWidth = $(window).width();
	    var viewportHeight = $(window).height();   
		if (viewportHeight > viewportWidth) {
		// Portrait viewportHeight
		// popup 
		$("#popupAnswersAll").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popupAnswersAll").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popupAnswersAll").width() / 2)+'px'
	    });
		$("#popupWrongPassword").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popupWrongPassword").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popupWrongPassword").width() / 2)+'px'
	    });
	    $("#popUpInsertPassword").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popUpInsertPassword").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popUpInsertPassword").width() / 2)+'px'
	    });
		$("#popLogin").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popLogin").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popLogin").width() / 2)+'px'
	    });
		}if (viewportHeight < viewportWidth) {
        // Landscape
		//popup 
		$("#popupAnswersAll").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popupAnswersAll").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popupAnswersAll").width() / 2)+'px'
	    });
		$("#popupWrongPassword").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popupWrongPassword").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popupWrongPassword").width() / 2)+'px'
	    });
	    $("#popUpInsertPassword").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popUpInsertPassword").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popUpInsertPassword").width() / 2)+'px'
	    });
		$("#popLogin").css({
	        'position': 'absolute',
	        'top': (viewportHeight/2-$("#popLogin").height() / 2)+'px',
	        'left': (viewportWidth/2-$("#popLogin").width() / 2)+'px'
	    });
		}
	}).resize();

//		navigate to positions page
		$("#backtoScoursespositionpage").click(function(){
			navTo("#coursesPosition");
		});	    


//		Button not login
		$("#btnXLog").click(function() {
			var id = $(this).attr("id");
			if (id == "btnXLog") {
				$("#Employee_no").val("");
				$("#password").val("");
				$("#popUp").hide();
			}
		});
			
//		close popup button X
		$("#btnClose").click(function() {
			var id = $(this).attr("id");
			if (id == "btnClose") {
				$("#Employee_no").val("");
				$("#password").val("");
				$("#popUp").hide();
			}
		});
		
//		close popup button X
		$("#btnCloseAlertAnswersAll").click(function() {
			var id = $(this).attr("id");
			if (id == "btnCloseAlertAnswersAll") {
				$("#popupAlertAnswersAll").hide();
			}
		});
		
		$("#btnCloseAlertWrongPassword").click(function() {
			var id = $(this).attr("id");
			if (id == "btnCloseAlertWrongPassword") {
				$("#popupAlertWrongPassword").hide();
			}
		});
		
		$("#btnCloseAlertInsertPassword").click(function() {
			var id = $(this).attr("id");
			if (id == "btnCloseAlertInsertPassword") {
				$("#popUpAlertInsertPassword").hide();
			}
		});

//		event to show and hide popup
		$("#S_btnSubmitdata").click(function() {  
			if($('input[id="S_Pick_Q1_2_5"]:checked').val() =="5" &&  $('#S_Pick_Q1_2_5_comment').val()==""){
				$("#popupAlertAnswersAll").show();
				return false;
			}
			if($('input[id="S_Pick_Q2_5"]:checked').val() =="5" &&  $('#S_Pick_Q2_comment').val()==""){
				$("#popupAlertAnswersAll").show();
				return false;
			}
			if(($('input[name="S_Pick_Q1"]:checked').val() =="1" || $('input[name="S_Pick_Q1"]:checked').val() =="2" || $('input[name="S_Pick_Q1"]:checked').val() =="3" || $('input[name="S_Pick_Q1"]:checked').val() =="4" || $('input[name="S_Pick_Q1"]:checked').val() =="5" || $('input[name="S_Pick_Q1"]:checked').val() =="6" || $('input[name="S_Pick_Q1"]:checked').val() =="7") &&  $('#S_Pick_Q1_2_no_comment').val()==""){
				$("#popupAlertAnswersAll").show();
				return false;
			}
			if(($('input[name="S_Pick_Q1"]:checked').val() =="8" || $('input[name="S_Pick_Q1"]:checked').val() =="9" || $('input[name="S_Pick_Q1"]:checked').val() =="10")
					&& (checkCheckboxInput("S_Pick_Q1_2_1")==""
					&& checkCheckboxInput("S_Pick_Q1_2_2")==""
					&& checkCheckboxInput("S_Pick_Q1_2_3")==""
					&& checkCheckboxInput("S_Pick_Q1_2_4")==""
					&& checkCheckboxInput("S_Pick_Q1_2_5")=="")){
				$("#popupAlertAnswersAll").show();
				return false;
			}
			if(checkRadioInput("S_Pick_Q1")==""
				|| (checkCheckboxInput("S_Pick_Q2_1")==""
				&& checkCheckboxInput("S_Pick_Q2_2")==""
				&& checkCheckboxInput("S_Pick_Q2_3")==""
				&& checkCheckboxInput("S_Pick_Q2_4")==""
				&& checkCheckboxInput("S_Pick_Q2_5")=="")
				|| checkTextInput("#courseEvaluationTitledb")==""
				|| checkTextInput("#courseEvaluationTitleIDdb")==""
				){

				$("#popupAlertAnswersAll").show();
			
				return false;
			}
	    	 else{
			var id = $(this).attr("id");
			if (id == "S_btnSubmitdata") {
				$("#popUp").show();
			}
			}
		});
		
//		check for login
	    $('#btnLogin').click(function()
	    	    {  
					{
	    	       var Employee_no=$('#Employee_no').val();
	    	       var password=$('#password').val();
	    	       if(Employee_no=="" || password==""){
	    	    	   $("#popUpAlertInsertPassword").show();
	    	    	   return false;
	    	       }
	    	       $.ajax({
	    	            type: "POST",
	    	            url: loginDomain,
	    	            data:{"Emp_no":Employee_no,"Emp_pass":password},
	    	            success: function (data) {
	    	            	
	    	                   if(data){
	    	                	   $("#popupAlertWrongPassword").show();
	    	             					      }else{
//	    	        	    	                	check and post feedback
	    	             					    	 if($("#S_q1_2_if_yes1").hide()) {
	    	             								if($('input[id=S_Pick_Q1_2_1]').is(':checked')){
	    	             									$('#S_Pick_Q1_2_1').prop('checked', true).val(1);
	    	             								}else{
	    	             									$('#S_Pick_Q1_2_1').prop('checked', true).val(0);
	    	             								}
	    	             								if($('input[id=S_Pick_Q1_2_2]').is(':checked')){
	    	             									$('#S_Pick_Q1_2_2').prop('checked', true).val(2);
	    	             								}else{
	    	             									$('#S_Pick_Q1_2_2').prop('checked', true).val(0);
	    	             								}
	    	             								if($('input[id=S_Pick_Q1_2_3]').is(':checked')){
	    	             									$('#S_Pick_Q1_2_3').prop('checked', true).val(3);
	    	             								}else{
	    	             									$('#S_Pick_Q1_2_3').prop('checked', true).val(0);
	    	             								}
	    	             								if($('input[id=S_Pick_Q1_2_4]').is(':checked')){
	    	             									$('#S_Pick_Q1_2_4').prop('checked', true).val(4);
	    	             								}else{
	    	             									$('#S_Pick_Q1_2_4').prop('checked', true).val(0);
	    	             								}
	    	             								if($('input[id=S_Pick_Q1_2_5]').is(':checked')){
	    	             									$('#S_Pick_Q1_2_5').prop('checked', true).val(5);
	    	             								}else{
	    	             									$('#S_Pick_Q1_2_5').prop('checked', true).val(0);
	    	             								}
	    	             					      }
	    	             								
	    	             								if($('input[id=S_Pick_Q2_1]').is(':checked')){
	    	             									$('#S_Pick_Q2_1').attr('checked', true).val(1);
	    	             								}else{
	    	             									$('#S_Pick_Q2_1').attr('checked', true).val(0);
	    	             								}
	    	             								if($('input[id=S_Pick_Q2_2]').is(':checked')){
	    	             									$('#S_Pick_Q2_2').attr('checked', true).val(2);
	    	             								}else{
	    	             									$('#S_Pick_Q2_2').attr('checked', true).val(0);
	    	             								}
	    	             								if($('input[id=S_Pick_Q2_3]').is(':checked')){
	    	             									$('#S_Pick_Q2_3').attr('checked', true).val(3);
	    	             								}else{
	    	             									$('#S_Pick_Q2_3').attr('checked', true).val(0);
	    	             								}
	    	             								if($('input[id=S_Pick_Q2_4]').is(':checked')){
	    	             									$('#S_Pick_Q2_4').attr('checked', true).val(4);
	    	             								}else{
	    	             									$('#S_Pick_Q2_4').attr('checked', true).val(0);
	    	             								}
	    	             								if($('input[id=S_Pick_Q2_5]').is(':checked')){
	    	             									$('#S_Pick_Q2_5').attr('checked', true).val(5);
	    	             								}else{
	    	             									$('#S_Pick_Q2_5').attr('checked', true).val(0);
	    	             								}

	    	      									if (checkRadioInput("S_Pick_Q1")
	    	      											|| checkCheckboxInput("S_Pick_Q1_2_1")
	    	      											|| checkCheckboxInput("S_Pick_Q1_2_2")
	    	      											|| checkCheckboxInput("S_Pick_Q1_2_3")
	    	      											|| checkCheckboxInput("S_Pick_Q1_2_4")
	    	      											|| checkCheckboxInput("S_Pick_Q1_2_5")
	    	      											|| checkCheckboxInput("S_Pick_Q2_1")
	    	      											|| checkCheckboxInput("S_Pick_Q2_2")
	    	      											|| checkCheckboxInput("S_Pick_Q2_3")
	    	      											|| checkCheckboxInput("S_Pick_Q2_4")
	    	      											|| checkCheckboxInput("S_Pick_Q2_5")
	    	      											|| checkTextInput("#S_Pick_Q1_2_5_comment")
	    	      											|| checkTextInput("#S_Pick_Q1_2_no_comment")
	    	      											|| checkTextInput("#S_Pick_Q2_comment")
	    	      										&& checkTextInput("#courseEvaluationTitledb")
	    	      										&& checkTextInput("#courseEvaluationTitleIDdb")
	    	      										&& checkTextInput("#Employee_no")
															) {
//	    	      										post data checked

	    	      										$.post(FeedbackFormSupervisorDomain,
	    	      												{
	    	      									    	
	    	      	  										Q1 : $('input[name="S_Pick_Q1"]:checked').val(),
	    	      	  										Q1_1 : $('input[id="S_Pick_Q1_2_1"]:checked').val(),
	    	      	  										Q1_2 : $('input[id="S_Pick_Q1_2_2"]:checked').val(),
	    	      	  										Q1_3 : $('input[id="S_Pick_Q1_2_3"]:checked').val(),
	    	      	  										Q1_4 : $('input[id="S_Pick_Q1_2_4"]:checked').val(),
	    	      	  										Q1_5 : $('input[id="S_Pick_Q1_2_5"]:checked').val(),
	    	      	  										Q2_1 : $('input[id="S_Pick_Q2_1"]:checked').val(),
	    	      	  										Q2_2 : $('input[id="S_Pick_Q2_2"]:checked').val(),
	    	      	  										Q2_3 : $('input[id="S_Pick_Q2_3"]:checked').val(),
	    	      	  										Q2_4 : $('input[id="S_Pick_Q2_4"]:checked').val(),
	    	      	  										Q2_5 : $('input[id="S_Pick_Q2_5"]:checked').val(),
	    	      	  										Q1_5_C_g : $('#S_Pick_Q1_2_5_comment').val(),
	    	      	  										Q1_5_C_b : $('#S_Pick_Q1_2_no_comment').val(),
	    	      	  										Q2_5_C : $('#S_Pick_Q2_comment').val(),
	    	      											courseTitle: $('#courseEvaluationTitledb').val(),
	    	      											Course_id: $('#courseEvaluationTitleIDdb').val(),
	    	      											Emp_no_create: $('#Employee_no').val()  								
	    	      	  										})
	    	      												.done(function() {
	    	      													window.location.href = "#coursesThanks";

	    	       												})
	    	       												.fail(function(ex) {
	    	       													alert(ex);
	    	      												});

	    	      												}


	    					                   }
	    					            }
	    	                   });
					}
	    	        });

//	    key in number only
		$('#Employee_no').bind('keyup paste', function(){
			var thisnumber = $(this);
			var valuenumber = thisnumber.val();
			var notNumber=new RegExp("[^0-9]","g");
			this.value = this.value.replace(/[^0-9]/g, '');
			if(valuenumber.match(notNumber)){
			$("#errmsg").html("Number Only").show().fadeOut(5000);
			}
		});
	  
//		navigate back to selection page and remove current values store
		$("#S_btnCanceldata").click(function(){
			localStorage.removeItem("course");
			localStorage.removeItem("trainer");
			localStorage.removeItem("date_time");
			localStorage.removeItem("venue");
			$('#courseEvaluationTitledb').val('');
			$('#courseEvaluationTitleIDdb').val('');
			navTo("#coursesPosition");
		});
		
		//function to check checkbox
		function checkCheckboxInput(answer) {
			if ($('input[id="' + answer + '"]:checked').length > 0) {
				
				return true;
			} else {
				return false;
			}
		}
		
	//function to check radio button
	function checkRadioInput(answer) {
		if ($('input[name="' + answer + '"]:checked').length > 0) {
			
			return true;
		} else {
			return false;
		}
	}
	
	//function to check textarea
	function checkTextInput(answers) {
		if ($(answers).val().trim().length > 0) {
			
			return true;
		} else {
			return false;
		}
	}
		
	});


	// *** coursesThanks *** //
	router.addRoute('coursesThanks', function() {//X
		$('body').html(new coursesThanksView().render().$el);
		$('body').scrollTop(0);
//Jquery		
//		body color
		$('body').css('background-color', 'white');

//		navigate to Selection page
		$("#linkbackhome").click(function(){
			navTo("#");
		});
		
	});
//	
	router.start();

	/*
	 * ---------------------- Event Registration ------------------------X
	 */
	document.addEventListener("deviceready", function() {
		FastClick.attach(document.body);
		document.addEventListener("backbutton", onBackKeyDown, false);
		nativeOpen = cordova.plugins.disusered.open;
	}, false);

	/*
	 * ---------------------- Local Functions ----------------------X
	 */
	function onBackKeyDown(e) {
		e.preventDefault();
	}

	function navTo(loc) {
		self.location = loc;
	}

}());
