package com.example.bballengine;


import java.util.List;

public class Response {
    public String get;
    public List<String> errors;
    public int results;
    public List<Player> response;

    // Getters and setters
    public String getGet() { return get; }
    public void setGet(String get) { this.get = get; }
    public List<String> getErrors() { return errors; }
    public void setErrors(List<String> errors) { this.errors = errors; }
    public int getResults() { return results; }
    public void setResults(int results) { this.results = results; }
    public List<Player> getResponse() { return response; }
    public void setResponse(List<Player> response) { this.response = response; }
}
