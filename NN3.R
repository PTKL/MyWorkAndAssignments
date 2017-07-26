# A function implementing the 3-Nearest Neighbours algorithm
knn3 <- function(trainObject,testObject,trainLabel){
  predicted <- rep(0,nrow(testObject))     # initializing the predicted labels
  for(testRow in 1:nrow(testObject)){      # going over all test observations
    nearestDistance1 <- Inf                # initializing the distance to the Nearest Neighbour
    nearestLabel1 <- 0                     # initializing the label of the Nearest Neighbour
    nearestDistance2 <- Inf                # initializing the distance to the second Nearest Neighbour
    nearestLabel2 <- 0                     # initializing the label of the second Nearest Neighbour
    nearestDistance3 <- Inf                # initializing the distance to the third Nearest Neighbour
    nearestLabel3 <- 0                     # initializing the label of the third Nearest Neighbour
    for(trainRow in 1:nrow(trainObject)){  # going over all training observations
      distance <- sum((trainObject[trainRow,] - testObject[testRow,])^2)  # in fact this is the squared Euclidean distance
      # updating nearestDdistance's:
      if(distance < nearestDistance3){
        if(distance < nearestDistance2){
          if(distance < nearestDistance1){  # now we know that the training object that we are processing is the Nearest Neighbour (so far)
            nearestDistance3 <- nearestDistance2
            nearestLabel3 <- nearestLabel2
            nearestDistance2 <- nearestDistance1
            nearestLabel2 <- nearestLabel1
            nearestDistance1 <- distance
            nearestLabel1 <- trainLabel[trainRow]
          }
          else{  # now we know that the training object that we are processing is the second Nearest Neighbour (so far)
            nearestDistance3 <- nearestDistance2
            nearestLabel3 <- nearestLabel2
            nearestDistance2 <- distance
            nearestLabel2 <- trainLabel[trainRow]
          }
        }
        else{  # now we know that the training object that we are processing is the third Nearest Neighbour (so far)
          nearestDistance3 <- distance
          nearestLabel3 <- trainLabel[trainRow]
        }
      }
    }
    # Computing the majority label among the three Nearest Neighbours:
    predicted[testRow] <- nearestLabel1     # the default prediction
    if (nearestLabel2==nearestLabel3){      # the only case where the majority label will be different
      predicted[testRow] <- nearestLabel2   # predicting with the majority label
    }
  }
  return(predicted)
}
