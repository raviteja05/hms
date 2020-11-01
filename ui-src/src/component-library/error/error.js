import React from 'react'
export const ErrorComponent=(props)=>{
    return (
<div class="container" style={{"position":"relative","min-height":"50vh"}}>
        <div class="row">
            <div class="col" style={{"max-width": "25%"}}><i class="fa fa-gears" style={{"font-size": "180px","padding": "30px"}}></i></div>
            <div class="col">
                <h1 class="text-left" style={{"padding-top": "30px"}}>Oops! Requested URL not found</h1>
                <p class="text-left">We can't find what you are looking for. Please check the address and try again!</p>
            </div>
        </div>
    </div>
    )
}