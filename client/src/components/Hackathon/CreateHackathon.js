import React, { Component } from "react";
import axios from "axios";
import { Redirect } from "react-router";
import Header from "../Admin/AdminHeader";
import Footer from "../Miscellanous/Footer";
import { Form, Select } from 'antd';

const listOfUsers = [''];

export default class CreateHackathon extends Component {
  constructor(props) {
    super(props);
    this.state = {
      eventName: "",
      description: "",
      fee: "",
      startTime: "",
      endTime: "",
      minTeamSize: "",
      maxTeamSize: "",
      passIdToProps: "",
      tempJudge: "",
    
      fetchedUsers : [],
      judges: [],
      successFlag: false
    };

    this.eventNameHandler = this.eventNameHandler.bind(this);
    this.descriptionHandler = this.descriptionHandler.bind(this);
    this.feeHandler = this.feeHandler.bind(this);
    this.minTeamSizeHandler = this.minTeamSizeHandler.bind(this);
    this.maxTeamSizeHandler = this.maxTeamSizeHandler.bind(this);
    this.submitHandler = this.submitHandler.bind(this);
    // this.judgeHandler = this.judgeHandler.bind(this);
    this.startTimeHandler = this.startTimeHandler.bind(this);
    this.endTimeHandler = this.endTimeHandler.bind(this);
  }
  componentWillMount() {
    this.setState({
      successFlag: false
    });
  }

  componentDidMount() {
    var headers = {
      Authorization: localStorage.getItem("token")
    };

    axios
      .get("http://localhost:8080/users/getAllUsers", {
        headers
      })
      .then(response => {
        console.log(" response " + JSON.stringify(response.data))
        this.setState({
          fetchedUsers : response.data
        })
        console.log(" Judges :", this.state.fetchedUsers.length)

        for(var i = 0; i < this.state.fetchedUsers.length; i++) {
            listOfUsers.push(this.state.fetchedUsers[i].email)
        }
      })
      .catch(function(error) {
        console.log("error: " + error);
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
  // judgeHandler = h => {
  //   this.setState({
  //     tempJudge: h.target.value
  //   });
  // };
  startTimeHandler = h => {
    this.setState({
      startTime: h.target.value
    });
  };
  endTimeHandler = h => {
    this.setState({
      endTime: h.target.value
    });
  };

  handleOptionChange = judges => {
    this.setState({ judges });
  };

  submitHandler = h => {
    // h.preventDefault();

    // var emailList = this.state.tempJudge.split(",");
    // for (var i = 0; i < emailList.length; i++) {
    //   var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;

    //   var result = regex.test(emailList[i]);

    //   if (!result) {
    //     alert("Invalid Email");
    //     //document.getElementById("demo").innerHTML = "sorry enter a valid";
    //     return false;
    //   }

    //   //   document.getElementById("demo").innerHTML =
    //   //     "Ur email address is successfully submitted";
    //   console.log(" yes ... ", emailList);
    //   for (var i = 0; i < emailList.length; i++) {
    //     this.state.judges.push({
    //       email: emailList[i]
    //     });
    //   }
    //   console.log(this.state.judges);
    // }

    var theJudges = []
    for(var i = 0; i < this.state.judges.length; i++) {
      theJudges.push({
        'email' : this.state.judges[i]
      })
    }

    const data = {
      eventName: this.state.eventName,
      startTime: this.state.startTime,
      endTime: this.state.endTime,
      description: this.state.description,
      fee: this.state.fee,
      minTeamSize: this.state.minTeamSize,
      maxTeamSize: this.state.maxTeamSize,
      createdBy: localStorage.getItem("email"),
      judges: theJudges
      // judges : [
      //     {
      //         "email": "123@gmail.com"
      //     },
      //     {
      //         "email": "456@gmail.com"
      //     }
      // ]
    };
    console.log(" data " + data)
    // alert(JSON.stringify(data))
    // axios.defaults.withCredentials = true
    axios.post("http://localhost:8080/hackathons", data).then(response => {
      console.log(" response " + response.data);
      if (response.status === 200) {
        this.setState({
          successFlag: true
        });
      }
    });
  };

  render() {
    console.log(listOfUsers)
    const { judges } = this.state
    // const filteredOptions = listOfUsers.filter(o => !selectedItems.includes(o));
    const filteredOptions = listOfUsers;
    let redirectVar = null;
    if (this.state.successFlag) {
      redirectVar = <Redirect to='/searchHackathon'/>
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
                  <h2>Create A Hackathon</h2>
                  <br />
                </div>
                <form onSubmit={this.submitHandler}>
                  <div class="form-group">
                    <input
                      name="eventName"
                      class="form-control"
                      type="text"
                      placeholder="Enter the Event Name"
                      onChange={this.eventNameHandler}
                      required
                    />
                  </div>
                  <div class="form-group">
                    <input
                      name="description"
                      class="form-control"
                      type="text"
                      placeholder=" Description (10 chars)"
                      onChange={this.descriptionHandler}
                      required
                    />
                  </div>

                  <div class="form-group">
                    <input
                      name="startTime"
                      class="form-control"
                      type='Date'
                      placeholder="Start Date"
                      onChange={this.startTimeHandler}
                      required
                    />
                  </div>

                  <div class="form-group">
                    <input
                      name="endTime"
                      class="form-control"
                      type="Date"
                      placeholder="End Date"
                      onChange={this.endTimeHandler}
                      required
                    />
                  </div>

                  <div class="form-group">
                    <input
                      name="fee"
                      class="form-control"
                      type="text"
                      placeholder="Amount to Pay"
                      onChange={this.feeHandler}
                      required
                    />
                  </div>
                  <div class="form-group">
                    <input
                      name="minTeamSize"
                      class="form-control"
                      type="text"
                      placeholder="Minimum Team Size"
                      onChange={this.minTeamSizeHandler}
                      required
                    />
                  </div>
                  <div class="form-group">
                    <input
                      name="maxTeamSize"
                      class="form-control"
                      type="text"
                      placeholder="Maximum Team Size"
                      onChange={this.maxTeamSizeHandler}
                      required
                    />
                  </div>


                <div className="App">
                <div className="box effect1">
                    <div className="contentClass">
                        <Form.Item
                            
                            style={{ width: '100%' }}>
                            <Select
                                mode="multiple"
                                placeholder="Choose judge(s)"
                                value={judges}
                                onChange={this.handleOptionChange}
                                style={{ width: '100%' }}>
                                {filteredOptions.map(item => (
                                    <Select.Option key={item} value={item}>
                                        {item}
                                    </Select.Option>
                                ))}
                            </Select>
                        </Form.Item>
                    </div>
                </div>
            </div >


                  {/* <div class="form-group">
                    <input
                      name="team"
                      class="form-control"
                      type="text"
                      placeholder="Enter Judge Emails byseparator (,)"
                      onChange={this.judgeHandler}
                      required
                    />
                  </div> */}

                  <br />
                  <button
                    type="submit"
                    class="btn btn-secondary btn-lg btn-block"
                  >
                    Create
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
