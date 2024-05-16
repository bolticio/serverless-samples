package main

import (
	"fmt"
	"net/http"
)

func handler(w http.ResponseWriter, r *http.Request) {
	fmt.Fprintf(w, "Hello World!")
}

func main() {
	// Register the handler function to handle requests to "/"
	http.HandleFunc("/", handler)

	// Start the HTTP server on port 8080
	fmt.Println("Example app listening on port 8080!")
	http.ListenAndServe(":8080", nil)
}
