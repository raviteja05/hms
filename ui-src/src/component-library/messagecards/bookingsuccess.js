import React from "react";
export const BookingSuccess = () => {
  return (
    <div class="container" style={{"position":"relative","min-height":"50vh"}}>
      <div class="alert alert-success" role="alert">
        <span>
          Your booking is successful. You will shortly receive an email
          confirmation with appointment details.
          <br />
        </span>
      </div>
    </div>
  );
};