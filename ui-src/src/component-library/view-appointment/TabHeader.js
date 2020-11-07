import React from 'react'

export const TabHeader = (props) => {
    var role= window.data.auth.role
  
    return (
  
      <ul class="nav nav-tabs">
        <li class="nav-item">
          <a class="nav-link active" role="tab" data-toggle="tab" href="#tab-1">
            Issue Prescription
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" role="tab" data-toggle="tab" href="#tab-2" onClick={(ev)=>{props.getPrescriptions(props.customerId,role)}}>
            View Prescriptions
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" role="tab" data-toggle="tab" href="#tab-3" onClick={(ev)=>props.appointmentsHistory(props.customerId)}>
            Appointments History
          </a>
        </li>
        <li class="nav-item">
          <a class="nav-link" role="tab" data-toggle="tab" href="#tab-4">
            Appointments Notes
          </a>
        </li>
      </ul>
    );
  };
  