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
      successFlag: false
    };
    this.buttonHandler = this.buttonHandler.bind(this)
  }

  buttonHandler = h => {
    //h.preventDefault();

    console.log(' id ' + h.target.id)

    var item = {
      user_id: localStorage.getItem('userId'),
      organization_id: h.target.id
    };
    this.props.func(item);
  };

  componentDidMount() {
    // alert(this.props.props.id);
    // alert("local: " + localStorage.getItem("email"));
    //this.state.orgID:
  }

  render() {
    return (
      <div>
        <div class="form-group">
          <div class="card">
            <div class="card-body">
              <h6 class="card-title">
                {" "}
                {this.props.props.name}
                <span class="tab" />
                <h6 class="card-subtitle mb-2 text-muted">
                  {" "}
                  {this.props.props.description}
                </h6>
                <h6 class="card-subtitle mb-2 text-muted">
                  {" "}
                </h6>
                <button
                  type="button"
                  class="btn btn-outline-success btn-sm"
                  onClick={this.buttonHandler} id={this.props.props.id} 
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
