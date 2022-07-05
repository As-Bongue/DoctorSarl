$('#menu-btn').click(function(){
  $('#menu').toggleClass("active");
});

$('#logout').click(function () {
  $('#decon').toggleClass("show");
});


$(document).ready(function() {
  $("#dashboardTable").DataTable({
    'aoColumnDefs': [{
      'bSortable': false,
      'aTargets': [-1] /* 1st one, start by the right */
    }]
  });
})