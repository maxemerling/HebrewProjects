function Delta = gradient(Theta, X)
  
  L = length(Theta);
  
  Delta = cell(size(Theta));
  for layer = 1:L
    Delta{layer} = zeros(size(Theta{layer}));
  endfor
  
  Delta{L} = hypothesis(Theta, X);
  
  for layer = flip(1:(L-1))
    Delta(layer) = Theta{layer}' * Delta{layer + 1} .* 
  endfor
  
endfunction