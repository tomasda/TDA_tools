   $(function(){

           //set window scroll position if cookie is set
       window.scroll(0,getCookie('myCookie'));
       //unset cookie after setting scroll position
       //deleteCookie('myCookie'); 

       //make this class objects keep page scroll position
       jQuery(window).unload(function() {
        setCookie('myCookie', getPageScroll());
       });
        //-------------------



    }); 

