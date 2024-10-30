package main

import (
	"encoding/json"
	"log"
	"net/http"
	"strings"
)

// Define the handler function
func handler(context http.ResponseWriter, event *http.Request) {
	// Extract the path from the request URL and capitalize the first letter
	path := strings.TrimPrefix(event.URL.Path, "/")
	if path == "" {
		path = "World"
	} else {
		path = strings.Title(strings.ToLower(path))
	}

	// Initialize a map to hold the response body
	response := map[string]string{
		"message": "Hello, " + path + "!", // Set the message to "Hello, <path>!"
	}

	// Set the Content-Type header to application/json
	context.Header().Set("Content-Type", "application/json")

	// Encode the response map into JSON and write it to the response
	json.NewEncoder(context).Encode(response)
}

func main() {
	// Define the port to listen on
	port := ":8080"

	// Print the message when the server starts listening
	log.Println("Example app listening on port 8080!")

	// Create a new HTTP server
	http.HandleFunc("/", handler)

	// Start the server
	http.ListenAndServe(port, nil)
}
