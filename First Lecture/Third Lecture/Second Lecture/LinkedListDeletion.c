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

// Delete Head
struct Node* deleteHead(struct Node *head) {

    if (head == NULL) {
        return NULL;
    }

    struct Node *temp = head;

    head = head->next;

    if (head != NULL) {
        head->prev = NULL;
    }

    free(temp);

    return head;
}

// Delete Tail
struct Node* deleteTail(struct Node *head) {

    if (head == NULL) {
        return NULL;
    }

    // Only one Node
    if (head->next == NULL) {
        free(head);
        return NULL;
    }

    struct Node *temp = head;

    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->prev->next = NULL;

    free(temp);

    return head;
}

// Delete at any position
struct Node* deleteAtPosition(struct Node *head, int position) {

    if (head == NULL) {
        return NULL;
    }

    if (position == 1) {
        return deleteHead(head);
    }

    struct Node *temp = head;

    for (int i = 1; i < position && temp != NULL; i++) {
        temp = temp->next;
    }

    if (temp == NULL) {
        printf("Invalid Position\n");
        return head;
    }

    if (temp->next != NULL) {
        temp->next->prev = temp->prev;
    }

    if (temp->prev != NULL) {
        temp->prev->next = temp->next;
    }

    free(temp);

    return head;
}

// Traversal
void traversal(struct Node *head) {

    struct Node *temp = head;

    while (temp != NULL) {
        printf("%d <-> ", temp->data);
        temp = temp->next;
    }

    printf("NULL\n");
}

int main() {

    struct Node *head = createNode(10);

    head->next = createNode(20);
    head->next->prev = head;

    head->next->next = createNode(30);
    head->next->next->prev = head->next;

    head->next->next->next = createNode(40);
    head->next->next->next->prev = head->next->next;

    printf("Original List: ");
    traversal(head);

    // Delete Head
    head = deleteHead(head);

    // Delete Tail
    head = deleteTail(head);

    // Delete Position 2
    head = deleteAtPosition(head, 2);

    printf("After Deletion: ");
    traversal(head);

    return 0;
}