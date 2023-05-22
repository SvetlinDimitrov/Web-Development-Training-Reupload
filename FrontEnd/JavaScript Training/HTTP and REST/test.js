new Promise(function(resolve, reject) {
    setTimeout(function(){
        reject('done');
    },500);})
        .then(function(res){
    console.log('Then returned:'+res);
    }).catch(()=>console.log(`Error`));
    