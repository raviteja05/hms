import React from 'react'

export const textInput=(props)=>{
    
    return (<input className="form-control" name={props.inputName} type="text" onChange={props.input.onChange} style={props.input.style} name={props.inputName} placeholder={props.placeholder}/>)

}

export const emailInput=(props)=>{
    return (<input className="form-control" name={props.inputName} onChange={props.input.onChange} type="email" style={props.input.style} name={props.inputName} placeholder={props.placeholder}/>)

}

export const passwordInput=(props)=>{
    return (<input className="form-control" name={props.inputName} onChange={props.input.onChange} type="password" style={props.input.style} name={props.inputName} placeholder={props.placeholder}/>)

}

export const textAreaInput=(props)=>{
    return (<textarea className="form-control" name={props.inputName} onChange={props.input.onChange} style={props.input.style} name={props.inputName} placeholder={props.placeholder}></textarea>)

}

export const SubmitButton=(props)=>{
    
    return (<button className="btn btn-primary btn-block" name={props.inputName} type="submit" onClick={props.onSubmit} style={props.style}>{props.value}</button>)

}
