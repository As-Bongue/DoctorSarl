$('#menu-btn').click(function(){
  $('#menu').toggleClass("active");
});

$('#logout').click(function () {
  $('#decon').toggleClass("show");
});

//etat dossier section

$('.refresh-dossier').click(function () {
  $('.etat-serv').toggleClass("active_dossier");
});


$(document).ready(function() {
  $("#dashboardTable").DataTable({
    'aoColumnDefs': [{
      'bSortable': false,
      'aTargets': [-1] /* 1st one, start by the right */
    }]
  });
})
