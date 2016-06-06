var i = 3;
var addChoice = function (){
    $(".choices").append('<input type="text" name="choice" placeholder="Choice ' + i.toString() + '" class="field">');
    i++;
};

var currentChoice;

$('.choice').on("click", function() {
    if (currentChoice != null) {
        currentChoice.removeClass("current");
    }

    $(this).addClass("current");
    currentChoice = $(this);
});

$('.choice-submit').on("click", function() {
    if (currentChoice == null) {
        return;
    }

    window.location.href = "/credit4_war_exploded/bet.action?choiceId=" + currentChoice.attr("id");

    currentChoice = null;
});

