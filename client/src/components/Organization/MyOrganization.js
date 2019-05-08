import React, { Component } from "react";
import axios from "axios";
import { Redirect } from "react-router";
import Header from "../Miscellanous/Header";
import Footer from "../Miscellanous/Footer";

export default class MyOrganization extends Component {
  constructor(props) {
    super(props);
    this.state = {
      email: "",
      organization: "",
      hasOrganization: false,
      successFlag: false
    };

    this.eventNameHandler = this.eventNameHandler.bind(this);
    this.descriptionHandler = this.descriptionHandler.bind(this);
    this.feeHandler = this.feeHandler.bind(this);
    this.minTeamSizeHandler = this.minTeamSizeHandler.bind(this);
    this.maxTeamSizeHandler = this.maxTeamSizeHandler.bind(this);
    this.submitHandler = this.submitHandler.bind(this);
  }

  componentDidMount() {
    // axios
    //   .get(`http://localhost:8080/userOrganization/${this.state.email}`)
    //   .then(response => {
    //     console.log(response.data);
    //     if (response.status === 200) {
    //       this.setState({
    //         organization: response.data,
    //         hasOrganization: true
    //       });
    //     }
    //   });

    this.setState({
      organization: "myOrg",
      hasOrganization: false
    });
  }

  componentWillMount() {
    this.setState({
      successFlag: false
    });
  }

  eventNameHandler = h => {
    this.setState({
      eventName: h.target.value
    });
  };
  descriptionHandler = h => {
    this.setState({
      description: h.target.value
    });
  };
  feeHandler = h => {
    this.setState({
      fee: h.target.value
    });
  };
  minTeamSizeHandler = h => {
    this.setState({
      minTeamSize: h.target.value
    });
  };
  maxTeamSizeHandler = h => {
    this.setState({
      maxTeamSize: h.target.value
    });
  };

  submitHandler = h => {
    h.preventDefault();
    const data = {
      eventName: this.state.eventName,
      description: this.state.description,
      fee: this.state.fee,
      minTeamSize: this.state.minTeamSize,
      maxTeamSize: this.state.maxTeamSize
    };
    // axios.defaults.withCredentials = true
    axios.post("http://localhost:8080/hackathons", data).then(response => {
      console.log(response.data.id);
      if (response.status === 200) {
        this.setState({
          successFlag: true
        });
      }
    });
  };

  render() {
    let redirectVar = null;
    if (this.state.successFlag) {
      redirectVar = (
        <Redirect
          to={{
            pathname: "/hackathonDetails",
            state: { id: this.state.passIdToProps }
          }}
        />
      );
    }

    let orgUI = null;
    if (this.state.hasOrganization) {
      orgUI = (
        <div>
          <h3 class="card-title">
            Organization Name: {this.state.organization}
            <span class="tab" />
          </h3>
          {/* <h6 class="card-subtitle mb-2 text-muted"> Subtitle</h6>
          <p class="card-text">something</p> */}
          <button type="button" class="btn btn-danger btn-lg btn-block">
            Leave
          </button>
        </div>
      );
    } else {
      orgUI = (
        <div>
          <h4 class="card-title">
            You are not a part of any organization currently
            <span class="tab" />
          </h4>
          {/* <h6 class="card-subtitle mb-2 text-muted"> Subtitle</h6>
        <p class="card-text">something</p> */}
          {/* <button type="button" class="btn btn-danger btn-lg btn-block">
            Leave
          </button> */}
        </div>
      );
    }
    return (
      <div style={{ backgroundColor: "#f2f2f2" }}>
        {redirectVar}
        <Header />
        <div>
          <div>
            <div class="hackathon-login-form">
              <div class="hackathon-main-div">
                <div class="hackathon-panel">
                  {/* <img src={openhacklogo} width="75px" height="75px" /> */}
                  <h2>My Organization</h2>

                  <br />
                </div>
                <div class="form-group">
                  <div class="card">
                    <div class="card-body">{orgUI}</div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <Footer />
      </div>
    );
  }
}
