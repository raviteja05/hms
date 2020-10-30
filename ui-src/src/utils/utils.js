export const formatDate=(today)=> {
    
    var dd = today.getDate();
    var mm = today.getMonth() + 1;
    var yyyy = today.getFullYear();
    if (dd < 10) {
      dd = "0" + dd;
    }
    if (mm < 10) {
      mm = "0" + mm;
    }
    today = dd + "-" + mm + "-" + yyyy;
    return today;
  }
  export const transform=(data)=> {
    var transformedData = [];
    
    if (Object.keys(data)) {
      var subArray = [];
      for (var i = 0; i < Object.keys(data).length; i++) {
        
        if ((i>0&&i % 4 == 0)) {
          transformedData.push(subArray);
          subArray = [];
        }
        subArray.push(data[i]);
        
      }
      transformedData.push(subArray)
      return transformedData;
    }
  }