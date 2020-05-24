package com.project.spe.jwtutil;

public class JwtResponse {
    private String jwtString;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public JwtResponse(String jwtString,String status){
        this.jwtString = jwtString;
        this.status = status;
    }

    public String getJwtString() {
        return jwtString;
    }


}
