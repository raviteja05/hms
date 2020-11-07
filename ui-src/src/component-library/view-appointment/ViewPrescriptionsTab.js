import React from 'react'
import {connect} from 'react-redux'
import {prescription} from '../../actions'
import ViewPrescription from './ViewPrescription'


class ViewPrescriptionsTab extends React.Component{
  popup(id,role){
    this.props.prescription(id,role);
    document.getElementById('prescription-modal').style="display:block;background:lightgray;";
    document.getElementById('prescription-modal').className="modal fade show"
  }
  
    render(){
       
      var role=window.data.auth.role

        return ( <div class="table-responsive" style={{ width: "700px" }}>
        <table class="table">
          <thead>
            <tr>
              <th style={{ width: "150px" }}>Date</th>
              <th style={{ width: "200px" }}>Doctor</th>
              <th style={{ width: "200px" }}>Link</th>
            </tr>
          </thead>
          <tbody>
            {this.props.prescriptions&&this.props.prescriptions.map(el=><tr>
              <td>{el.date}</td>
              <td>Dr. {el.doctorViewData.firstName} {el.doctorViewData.lastName}</td>
              <td><button class="btn btn-primary" onClick={(ev)=>{this.popup(el.id,role)}}>View</button></td>
            </tr>)}
            
          </tbody>
        </table>
       <ViewPrescription prescription={this.props.data}/>
      </div>)

    }
}

const mapStateToProps=(state)=>{
  return {data:state.prescription}
}
  export default connect(mapStateToProps,{prescription})(ViewPrescriptionsTab);