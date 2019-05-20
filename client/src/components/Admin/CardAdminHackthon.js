import React, { Component } from "react";
import axios from "axios";
import { Redirect } from "react-router";
import Header from "../Miscellanous/Header";
import Footer from "../Miscellanous/Footer";
import AdminHeader from "../Admin/AdminHeader";

export default class CardAdminHackathon extends Component {
  constructor(props) {
    super(props);
    this.state = {
      hackathons : [],
      successFlag : false
    }
  }
  
  componentWillMount() {
    this.setState({
      successFlag : false
    })
  }

  componentDidMount() {
    var headers = {
      Authorization: localStorage.getItem("token")
    }; 
    axios.get("http://localhost:8080/hackathons/getAllHackathons", {
      headers
    }).then(response => {
      console.log(' the resposne :' + JSON.stringify(response.data))
      if(response.status === 200){
        this.setState({
            successFlag : true,
            hackathons : this.state.hackathons.concat(response.data)
        })
      } else{
        this.setState({
            successFlag : false
        })
      }
    });
  }

  render() {
    // let hackathon = null
    console.log("Hack : ", this.state.hackathons)
    let hackathon = null;
    if(this.state.successFlag){
      hackathon = this.state.hackathons.map(h =>{
        return(
            <div>
              <div class="form-group" style={{margin:60}} >
                <div class="card">
                  <div class="card-body">
                    <h6 class="card-title">
                      {" "}
                      {h.eventName}
                      <s   pan class="tab" />
                      {/* <button type="button" class="btn btn-outline-success btn-sm">
                        Manage
                      </button> */}
                    </h6>
                    <h6 class="card-subtitle mb-2 text-muted"> {h.startTime}</h6>
                    <p class="card-text">{h.endTime}</p>
                  </div>
                </div>
              </div>
          </div>
        )
      })
    }
    return(
      <div>
        <AdminHeader />
      {hackathon}
      </div>
    )
    // if(this.state.successFlag) {
    //   hackathon = this.props.hackathons.map(h => {
    //     console.log("H : ", h);
    //     return (
    //       <div>
    //         <div class="form-group" style={{margin:60}} >
    //           <div class="card">
    //             <div class="card-body">
    //               <h6 class="card-title">
    //                 {" "}
    //                 {h.eventName}
    //                 <s   pan class="tab" />
    //                 {/* <button type="button" class="btn btn-outline-success btn-sm">
    //                   Manage
    //                 </button> */}
    //               </h6>
    //               <h6 class="card-subtitle mb-2 text-muted"> {h.startTime}</h6>
    //               <p class="card-text"> {h.endTime}</p>
    //             </div>
    //           </div>
    //         </div>
    //       </div>
    //     )
    // })
    } 
    // else {
    //       return(
    //         <div>
    //             <AdminHeader />
    //             <h1> No Hackathons </h1>
    //        </div> 
    //     )    
    // }
    // if(this.state.hackathons) {
    //   return( 
    //     <div>
    //        <AdminHeader />
    //        {this.state.hackathons}
    //         <h1> No Hackathons </h1>
    //     </div>
    //   )
    // } else {
    //     return(
    //       <div>
    //           <AdminHeader />
    //           <h1> No Hackathons </h1>
    //       </div> 
    //     )
    // }
  
}
