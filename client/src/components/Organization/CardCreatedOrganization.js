import React, { Component } from "react";
import axios from "axios";
import { Redirect } from "react-router";
import Header from "../Miscellanous/Header";
import Footer from "../Miscellanous/Footer";

export default class CardCreatedOrganization extends Component {
  constructor(props) {
    super(props);
    this.state = {
      orgName: "",
      orgDescription: "",
      orgID: "",
      successFlag: false,
      done: false
    };
    this.buttonHandler = this.buttonHandler.bind(this);
  }

  buttonHandler = h => {
    //h.preventDefault();

    console.log(" prop out");

    var item = {
      user_id: localStorage.getItem("userId"),
      organization_id: h.target.id
    };
    this.props.func(item);
    this.state.done = true;
  };

  componentDidMount() {
    //alert("key" + this.props.key + " ***** " + this.props.props);
    console.log(
      "key" + this.props.k + " ***** " + JSON.stringify(this.props.props)
    );
    // alert("local: " + localStorage.getItem("email"));
    //this.state.orgID:
  }

  render() {
    console.log("Key : ", this.props.key);
    return (
      <div>
        <div class="form-group">
          <div
            class="card"
            style={{
              display: this.state.done === true ? "none" : "block"
            }}
          >
            <div class="card-body">
              <h6 class="card-title">
                {" "}
                Requested By:
                {" " + this.props.props.userName}
                <span class="tab" />
                <br />
                <h6 class="card-subtitle mb-2 text-muted">
                  {" "}
                  <br />
                  For Hackathon: {this.props.k}
                  <br />{" "}
                </h6>
                <h6 class="card-subtitle mb-2 text-muted"> </h6>
                <br />
                <button
                  type="button"
                  class="btn btn-outline-success btn-sm"
                  onClick={this.buttonHandler}
                  //id={this.props.props.id}
                >
                  View Join Requests
                </button>
              </h6>
            </div>
          </div>
        </div>
      </div>
    );
  }
}
