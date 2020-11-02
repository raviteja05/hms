import React from 'react'

const componentData=window.data.iconcardcontainer
export const DashBoardContainer = () => {
  return (
    <div className="container" style={{"position":"relative","min-height":"50vh"}}>
      <DashBoardWelcomMessage/>
      <div className="row">
           {componentData.contentCards.map(el=><DashBoardIconCard data={el}/>) }
            
        </div>
    </div>
  );
}

export const DashBoardWelcomMessage=()=>{
  var name=window.data.auth.name
    return (<div className="row">
    <div className="col" style={{"padding-bottom": "15px"}}>
      <h4>Welcome {name}</h4>
    </div>
  </div>)
}

export const DashBoardIconCard=(props)=>{
    return (<div className="col" style={{"max-width": "20%","height": "175px"}}>
    <div className="card border-white">
      <div
        className="card-body border rounded shadow-none"
        style={{"padding-top": "20px","margin-bottom": "20px","padding-bottom": "20px","width": "175px","height": "140px"}}
      >
        <div className="row">
          <div
            className="col offset-0 text-center"
            style={{"max-width": "100%","padding": "30px","padding-top": "5px","padding-left": "0px","height": "105px"}}
          >
            <a href={props.data.cardLink.url}><i
              className={props.data.iconName}
              style={{"font-size": "72px","padding-left": "35px","color": "rgb(59,153,224)"}}
            ></i></a>
            <h2
              className="text-center text-muted mb-2"
              style={{"padding-top": "15px","font-size": "12px","color": "rgb(59,153,224)","margin-left": "0px","width": "160px"}}
            >
              <strong>{props.data.heading}</strong>
            </h2>
          </div>
        </div>
      </div>
    </div>
  </div>)
}