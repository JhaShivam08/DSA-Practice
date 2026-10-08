#include <stdio.h>
#include <stdlib.h>

// Structure for creating a Node of the Linked List
struct Node {

    // Stores the data/value of the Node
    int data;
    // Stores the address of the next Node
    struct Node *next;
};

int main() {
    // Create an integer array containing 5 values
    int arr[] = {10, 20, 30, 40, 50};

    // Store the number of elements in the array
    int n = 5;

    // Create a head pointer and initially set it to NULL
    struct Node *head = NULL;
    // Create a temporary pointer and initially set it to NULL
    struct Node *temp = NULL;

    // Loop through each element of the array
    for (int i = 0; i < n; i++) {

         // Allocate memory for a new Node
        struct Node *newNode =
            (struct Node*)malloc(sizeof(struct Node));

          // Store the current array value in the new Node
        newNode->data = arr[i];

        // Initially, the new Node does not point to another Node
        newNode->next = NULL;
         
        // Check whether the Linked List is empty
        if (head == NULL) {
        
            // Make the new Node the first Node
            head = newNode;
        }
        else {
            // Start from the first Node
            temp = head;

            // Move temp until it reaches the last Node
            while (temp->next != NULL) {
                temp = temp->next;
            }

            // Connect the last Node to the new Node
            temp->next = newNode;
        }
    }

    // Display Linked List
    // Start traversing the Linked List from the first Node
    temp = head;

     // Continue until the end of the Linked List
    while (temp != NULL) {

        // Print the data stored in the current Node
        printf("%d -> ", temp->data);

          // Move to the next Node
        temp = temp->next;
    }

    // Print NULL to show the end of the Linked List
    printf("NULL");

    return 0;
}