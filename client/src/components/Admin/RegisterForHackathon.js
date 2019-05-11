import React, { Component } from "react";
import axios from "axios";
import { Redirect } from "react-router";
import Header from "../Miscellanous/Header";
import Footer from "../Miscellanous/Footer";

export default class RegisterForHackathon extends Component {
  constructor(props) {
    super(props);
    this.state = {
      hackathonId: 1,
      teamName: "",
      team: "",
      teamMembers: []
    };

    this.teamNameHandler = this.teamNameHandler.bind(this);
    this.submitHandler = this.submitHandler.bind(this);
    this.teamHandler = this.teamHandler.bind(this);
  }

  componentWillMount() {
    this.setState({
      successFlag: false
    });
  }

  teamNameHandler = h => {
    this.setState({
      teamName: h.target.value
    });
  };

  teamHandler = h => {
    this.setState({
      team: h.target.value
    });
  };

  submitHandler = h => {
    h.preventDefault();

    var emailList = this.state.team.split(",");
    for (var i = 0; i < emailList.length; i++) {
      var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;

      var result = regex.test(emailList[i]);

      if (!result) {
        alert("Invalid Email");
        //document.getElementById("demo").innerHTML = "sorry enter a valid";
        return false;
      }

      //   document.getElementById("demo").innerHTML =
      //     "Ur email address is successfully submitted";
      console.log(" yes ... ", emailList);
      for (var i = 0; i < emailList.length; i++) {
        this.state.teamMembers.push({
          userId: emailList[i],
          role: "programmer"
        });
      }
      console.log(this.state.teamMembers);
    }

    console.log(this.state.teamMembers);
    const data = {
      hackathonId: this.state.hackathonId,
      teamName: this.state.teamName,
      teamSize: this.state.teamMembers.length + 1,
      userId: localStorage.getItem("email"),
      teamMembers: this.state.teamMembers
    };
    axios.post("http://localhost:8080/teams", data).then(response => {
      console.log(" response from server : ", response.data);
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
            pathname: "/user",
            state: { id: this.state.passIdToProps }
          }}
        />
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
                  <h2>Register Team for Hackathon</h2>
                  <br />
                </div>
                <form onSubmit={this.submitHandler}>
                  <div class="form-group">
                    <input
                      name="teamName"
                      class="form-control"
                      type="text"
                      placeholder="Enter the Team Name"
                      onChange={this.teamNameHandler}
                      required
                    />
                  </div>
                  <div class="form-group">
                    <input
                      name="Team"
                      class="form-control"
                      type="text"
                      placeholder="Enter Team Emails byseparator (,)"
                      onChange={this.teamHandler}
                      required
                    />
                  </div>
                  <br />

                  <button
                    type="submit"
                    class="btn btn-secondary btn-lg btn-block"
                  >
                    Register
                  </button>
                  <br />
                </form>
              </div>
            </div>
          </div>
        </div>
        <Footer />
      </div>
    );
  }
}
