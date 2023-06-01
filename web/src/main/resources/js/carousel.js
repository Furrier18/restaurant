$("#elso").click(function(){
    $("#carouselkepek1").carousel(0);
    $("#carouselkepek2").carousel(0);
});
    $("#masodik").click(function(){
    $("#carouselkepek1").carousel(1);
    $("#carouselkepek2").carousel(1);
});
    $("#harmadik").click(function(){
    $("#carouselkepek1").carousel(2);
    $("#carouselkepek2").carousel(2);
});

    $(".carousel-control-prev").click(function(){
    $("#carouselkepek1").carousel("prev");
    $("#carouselkepek2").carousel("prev");
});
    $(".carousel-control-next").click(function(){
    $("#carouselkepek1").carousel("next");
    $("#carouselkepek2").carousel("next");
});

    $("#carouselkepek").on('slide.bs.carousel', function (){
    $("#carouselkepek1").carousel("next");
    $("#carouselkepek2").carousel("next");
});