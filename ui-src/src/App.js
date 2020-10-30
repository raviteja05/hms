import React from 'react'
function App({components}) {
  console.log("components")
  return (
    <React.Fragment>
      {components.map(El=><El/>)}
      
    </React.Fragment>
  );
}

export default App;
