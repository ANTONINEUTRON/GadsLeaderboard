package com.neutron.gadsleaderboard.ui.submission;

public class UserDetailsModel {
    String email;
    String fname;
    String lname;
    String gitHub;

    public UserDetailsModel(String email, String fname, String lname, String gitHub) {
        this.email = email;
        this.fname = fname;
        this.lname = lname;
        this.gitHub = gitHub;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getGitHub() {
        return gitHub;
    }

    public void setGitHub(String gitHub) {
        this.gitHub = gitHub;
    }
}
