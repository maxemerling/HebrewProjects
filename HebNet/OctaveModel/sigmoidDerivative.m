function g_prime = sigmoidDerivative(z)
  
  g = sigmoid(z);
  g_prime = g .* (1 - g);
  
endfunction