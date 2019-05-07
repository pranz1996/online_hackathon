import React, { Component } from "react";
import axios from "axios";
import { Redirect } from "react-router";
import Header from "../Miscellanous/Header";
import Footer from "../Miscellanous/Footer";
import Iframe from "react-iframe";

export default class UserProfile extends Component {
  constructor(props) {
    super(props);
    this.state = {
      eventName: "",
      description: "",
      fee: "",
      minTeamSize: "",
      maxTeamSize: "",
      passIdToProps: "",
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
    console.log(
      "State Transferred " +
        JSON.stringify(this.props.location.state) +
        "referrer: " +
        this.props.location.state.referrer
    );
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
    const potrait = "https://photos.app.goo.gl/jKPun2yzC9bqSQCy8";
    return (
      <div style={{ backgroundColor: "#243e8c" }}>
        <div style={{ backgroundColor: "#243e8c" }}>
          <Header />
          <div style={{ backgroundColor: "#243e8c" }}>
            <div class="login-form">
              <div class="user-div">
                <b>
                  <h2>Profile</h2>
                </b>
                <hr />
                <div class="row">
                  <img
                    src="https://media.licdn.com/dms/image/C5603AQGzAhB6fkRwvw/profile-displayphoto-shrink_200_200/0?e=1561593600&v=beta&t=vw9CbuuiDs83Hgdc8oj4JcJXcTdkj_glBY5qLL7n6Ik"
                    width="100px"
                    height="100px"
                  />
                  <div class="col">
                    <input
                      type="file"
                      class="form-control-file"
                      id="exampleFormControlFile1"
                    />
                    <br />
                    <button
                      type="button"
                      class="btn btn-outline-primary btn-sm btn-block"
                    >
                      Upload
                    </button>
                    <a href="#" class="toggle">
                      (edit profile)
                    </a>
                  </div>
                </div>
                <br />
                <form>
                  <div class="form-row">
                    <div class="form-group col-md-6">
                      <label for="inputEmail4">Email</label>
                      <input
                        type="email"
                        class="form-control"
                        id="inputEmail4"
                        placeholder="Email"
                      />
                    </div>
                    <div class="form-group col-md-6">
                      <label for="input">Username</label>
                      <input
                        type="password"
                        class="form-control"
                        id="inputPassword4"
                        placeholder="Username"
                      />
                    </div>
                  </div>
                  <div class="form-row">
                    <div class="form-group col-md-6">
                      <label for="inputEmail4">Organization</label>
                      <input
                        type="email"
                        class="form-control"
                        id="inputEmail4"
                        placeholder="Email"
                      />
                    </div>
                    <div class="form-group col-md-6">
                      <label for="input">Business Title</label>
                      <input
                        type="password"
                        class="form-control"
                        id="inputPassword4"
                        placeholder="Username"
                      />
                    </div>
                  </div>
                  <div class="form-group">
                    <label for="inputAddress">Address</label>
                    <input
                      type="text"
                      class="form-control"
                      id="inputAddress"
                      placeholder="1234 Main St"
                    />
                  </div>
                  <div class="form-row">
                    <div class="form-group col-md-6">
                      <label for="inputCity">City</label>
                      <input type="text" class="form-control" id="inputCity" />
                    </div>
                    <div class="form-group col-md-4">
                      <label for="inputState">State</label>
                      <select id="inputState" class="form-control">
                        <option selected>Choose...</option>
                        <option>...</option>
                      </select>
                    </div>
                    <div class="form-group col-md-2">
                      <label for="inputZip">Zip</label>
                      <input type="text" class="form-control" id="inputZip" />
                    </div>
                  </div>

                  <div class="form-group">
                    <label for="exampleFormControlTextarea1">About Me</label>
                    <textarea
                      class="form-control"
                      id="exampleFormControlTextarea1"
                      rows="4"
                    />
                  </div>
                </form>
              </div>
            </div>
          </div>
          <Footer />
        </div>
      </div>
    );
  }
}
