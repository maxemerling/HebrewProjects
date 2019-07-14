function J = costFunction(Theta, X, y, lambda)
  
  h = hypothesis(Theta, X);
  
  J = (-1/m) * sum(sum(((y .* log(h)) - ((1-y) .* log(1-h)))));
  
  %regularization
  Theta_sum = 0;
  for j = 1:length(Theta)
    Theta_sum += sum(sum(Theta{j} .^ 2));
  endfor
  
  J += (lambda / (2*m)) * Theta_sum;
  
endfunction