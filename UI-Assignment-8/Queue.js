function Queue() {
    this.rear = 0;
    this.front = 0;
    this._storage = {};
}
 
Queue.prototype.size = function() {
    return this.front - this.rear;
};
 
Queue.prototype.enqueue = function(data) {
    this._storage[this.front] = data;
    this.front++;
};
 
Queue.prototype.dequeue = function() {
    var oldestIndex = this.rear,
        newestIndex = this.front,
        deletedData;
    var message = {
            failure: 'Failure: non-existent node in this list.'
        };
 
    if (oldestIndex !== newestIndex) {
        deletedData = this._storage[oldestIndex];
        delete this._storage[oldestIndex];
        this.rear++;
 
        return deletedData;
    }
    else{
        throw new Error(message.failure);
    }
};