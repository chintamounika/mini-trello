
$(document).ready(function(){
    $("#save").click(function(){

        $("#toast").htmlText("Card saved");
        $("#toast").fadeIn("slow", function() {
            $("#toast").visibility = false;
        });
    });
});
