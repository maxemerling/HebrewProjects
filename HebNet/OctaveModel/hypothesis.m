function h = hypothesis(Theta, X)
  
  %number of layers in network
  L = length(Theta) + 1;
  
  %add bias to input layer and transpose
  a = [ones(rows(X), 1) X]';
  
  %loop through hidden layers
  for j = 1:(L - 2)
    %multiply weights with previous layer's activation units
    z = Theta{j} * a;
    
    %calculate this layer's activation units
    a = sigmoid(z);
    
    %add bias
    a = [ones(rows(a), 1) ; a];
  endfor
  
  %output layer
  z = Theta{L - 1} * a;
  
  h = sigmoid(z)';
  
endfunction