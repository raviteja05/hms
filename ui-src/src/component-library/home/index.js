import React from 'react'

export const pageData = window.data;
export const HeroBanner=()=>{
    
    return (<React.Fragment>{pageData.herobanner&&<section class="clean-block clean-hero" style={{"background-image": "url('assets/img/Background.jpg')","color": "rgba(9, 162, 255, 0.85)","margin": "0px","max-height": "0px","min-height": "400px"}}>
    <div class="text">
        <h2>{pageData.herobanner.bannerHeading}</h2>
        <p>{pageData.herobanner.bannerSubHeading}</p><a href={pageData.herobanner.buttonURL}><button class="btn btn-outline-light btn-lg" type="button">{pageData.herobanner.buttonText}</button></a></div>
</section>}</React.Fragment>)
}

export const FeatureCardContainerComponent=()=>{
    return (
        <React.Fragment>{pageData.iconcardcontainer&&
        <section class="clean-block features" style={{"padding-bottom": "0px"}}>
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">{pageData.iconcardcontainer.heading}</h2>
                </div>
                <div class="row justify-content-center">
                  {pageData.iconcardcontainer.contentCards&&
                  pageData.iconcardcontainer.contentCards.map(el=> <FeatureCard data={el}/>)}
                   
                </div>
            </div>
        </section>}</React.Fragment>
    )
}

export const FeatureCard=(props)=>{
    
    return (<div class="col-md-5 feature-box"><i class={props.data.iconName}></i>
    <h4>{props.data.heading}</h4>
    <p>{props.data.description}</p>
</div>)

}