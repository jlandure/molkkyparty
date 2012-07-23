
function showList(data) {
  if (data && data.items) { 
    var groups = data.items;
    var users = groups[0].users;
    var items = [];
    $.each(groups, function(key, val) {
      var details = "<div class='beerDetails'><pre>";
      for (var prop in val) {
    	  if(!($.isArray(val[prop]))) {
            details += prop + ": " + val[prop] + "<br/>";
    	  }
      }
      details += "</pre></div>";
      items.push('<li>' + val.name + 
        '</span> - Id: ' + val.id + '<br/>' + details + '</li>');
    });
    
    $.each(users, function(key, val) {
        var UsersDetails = "<div class='beerDetails'><pre>";
        for (var prop in val) {
        	UsersDetails += prop + ": " + val[prop] + "<br/>";
        }
        UsersDetails += "</pre></div>";
        items.push('<li> Users' + 
          '</span> <br/>' + UsersDetails + '</li>');
      });

    $('<ol/>', {
      'class': 'beerItem',
      html: items.join('')
    }).appendTo('#results');
  }
}

var apiUrl = "http://localhost:8888/_ah/api/molkkyparty/v1/group";
$.ajax({
  url: apiUrl,
  dataType: 'json',
  contentType: 'application/json',
  type: "GET",
  success: function(data) {
    $('#results').html('');
    showList(data);
  },
  error: function(xhr, ajaxOptions, thrownError) {
    console.error("Beer list error: " + xhr.status) + " err: " + thrownError;
    $('<h3/>', {
        html: "Could not find beers"
      }).appendTo('#results');
  }
 
});
