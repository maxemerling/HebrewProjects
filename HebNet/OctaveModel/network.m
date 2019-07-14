function Theta = network(hidden_layer_sizes, X, y)
  
  [m, n] = size(X);
  
  layer_sizes = [n hidden_layer_sizes size(y, 2)];
  num_layers = length(layer_sizes);
  
  %create a num_layers by 
  
  Theta = cell(1, num_layers - 1);
  for layer = 1:length(Theta)
    Theta{layer} = rand(layer_sizes(layer + 1), ...
          layer_sizes(layer) + 1);
  endfor
  
  
  
endfunction
    