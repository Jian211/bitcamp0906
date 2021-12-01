// handler 모음

// 박스 생성 
$('.box').on('click',handleMakeBox);
$('.box').on('click','.boxStyle',function(){
    console.log("asd");
});

const boxStyle = {
    width : 40,
    height: 40,
    backgroundColor : 'pink'
}

function handleMakeBox(e){
    $('<div></div>').css(boxStyle).appendTo('.box');      
    $('<div></div>').addClass('boxStyle').appendTo('.box');      
}

    

function handlerWriteText(){
    console.log("dd")
    $(this).text('dddd');
}