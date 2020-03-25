var app = (function () {

    function find(nombre) {
        initMap();
        getByName(nombre,_table);
    }

    function getByName(name,callback) {

        var getPromise = $.get("http://localhost:8080/cities/"+name);
        getPromise.then(
            function(data){
                console.log(JSON.parse(data));
                _table(JSON.parse(data));
            },
            function(){
                console.log('error')
            }
        );
        return getPromise;
    }

    function _table(data){
        $("#cityRows").empty();
        data.map(function(element){
            var markup = "<tr> <td>"+ element.city +"</td> <td>"+element.province+"</td> <td>"+ element.country +"</td> <td>"+ element.lastUpdate +"</td> <td>"+ element.keyId +"</td><td>"+ element.confirmed +"</td><td>"+ element.deaths +"</td><td>"+ element.recovered +"</td></tr>";
            $("#cityRows").append(markup)
        });

    }

    return {
        init: function () {
            initMap();
        },
        find:find
    }
})();