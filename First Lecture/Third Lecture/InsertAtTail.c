#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
    struct Node *prev;
};

struct Node* createNode(int data) {

    struct Node *newNode =
        (struct Node*)malloc(sizeof(struct Node));

    newNode->data = data;
    newNode->next = NULL;
    newNode->prev = NULL;

    return newNode;
}

// Insert Node at Tail
struct Node* insertAtTail(struct Node *head, int data) {

    struct Node *newNode = createNode(data);

    // If Linked List is empty
    if (head == NULL) {
        return newNode;
    }

    // Start from head
    struct Node *temp = head;

    // Find the last Node
    while (temp->next != NULL) {
        temp = temp->next;
    }

    // Connect last Node with new Node
    temp->next = newNode;
    newNode->prev = temp;

    return head;
}

// Display Linked List
void traverse(struct Node *head) {

    struct Node *temp = head;

    while (temp != NULL) {

        printf("%d ", temp->data);

        temp = temp->next;
    }
}

int main() {

    struct Node *head = createNode(1);

    head = insertAtTail(head, 2);
    head = insertAtTail(head, 3);

    traverse(head);

    return 0;
}